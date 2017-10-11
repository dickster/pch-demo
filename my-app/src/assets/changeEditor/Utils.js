var Utils = (function() {

    var param = function(name, defaultValue) {
        var p = (window.location.search.split(name + '=')[1] || '').split('&')[0];
        return p ? p : defaultValue;
    };

    var getJson = function(parameter, dflt, callback) {
        // if specified in URL, that wins otherwise we'll use default.
        var file = param(parameter,dflt);
        file = 'data/' + file;
        if (file.indexOf('.json')==-1) {
            file = file + '.json';
        }
        console.log('loading data from ' + file);
        return $.getJSON(file, callback).fail(
            function(jqXHR, textStatus, errorThrown) {
                alert('getJSON request failed! ' + textStatus);
            });
    };

    //  methods returned by Utils object here....

    return {

        // only use this for debugging.  in production you just want to do....
        //    wtw.changeEditor.init(opts);
        // this method just allows you to easily override config & changes data via url params & external .json files.

        debugChangeEditor: function(changes,config,template) {
            var options = {};

            if (!changes) changes = 'changes';   //use default file name if none provided.
            if (!config) config = 'config';

            var assignChanges = function(json) { options.changes=json;};
            var assignConfig = function(json) { options.config=json;};

            $.when( getJson('changes', changes, assignChanges),
                    getJson('config', config, assignConfig) )
                .then( function() {
                    // this is the only line you need to start editor.
                    // the rest is there to facilitate loading test data based on url parameters (QA use case only).
                    wtw.changeEditor.init(options);
                }, function() {
                    alert('cant load config/changes test data');
                } );

        },

        ensureVisible : function($el,$container,scroll) {
            if (!$container) {   // assume it's the immediate parent.
                $container = $el.parent();
            }
            if ( !($el.position().top + $el.height() > 0 && $el.position().top < $container.height()) ) {
                if (scroll) {
                    scroll($el, $container);
                }
                else {
                    $container.scrollTop($container.scrollTop() + $el.position().top);
                }
            }
        },

        ensureEasySectionVisible: function ($el) {
            if ($el.is(':visible')) return;

            var $section = $el.parents('.easy-section');
            if ($section.length) {
                var $header = $section.find('.easy-section-heading');
                // TODO : not tested yet...confirm behaviour of easy-sections.
                if ($section.is('.minimized') || $header.is('.minimized')) {
                    // BLARGH!  because the click handler is done inline (directly added to html, *not* via jquery event handling)
                    // i must access the DOM element directly and invoke handler here.
                    // note that if someone ever takes this handler out of the HTML we are pooched and it will have to be fixed.
                    $section.find('.easy-section-minmax')[0].onclick();
                }
                // NOTE : shouldn't be using invalid html attributes here.  dangerous!   titlecollapse, titleexpand etc...
                //<div id="id1b_minmax" onclick="easySectionToggleMinMax(this);"
                //  data-toggle="tooltip" title="Collapse Section" titleexpand="Expand Section" titlecollapse="Collapse Section" class="persPolicy-easy-section-minmax easy-section-minmax maximized"></div>
            }
        },

        ensureInViewport: function($el, activeClass) {
            // check to see if parent 'easy-section' is closed...if so, open it.
            this.ensureEasySectionVisible($el);
            var activateIt = function() { $el.addClass(activeClass);};
            if (!this.isInViewport($el)){
                $('html, body').animate({ scrollTop: $el.offset().top - 75}, 350, activateIt);
            } else {
                activateIt();
            }
        },

        isInViewport: function($el) {
            var win = $(window);
            var viewTop = win.scrollTop();
            var viewBottom = viewTop + win.height();
            var top = $el.offset().top;
            var bottom = top + $el.height();
            return (viewTop<=top && viewBottom >= bottom);
        },

    };

}());
