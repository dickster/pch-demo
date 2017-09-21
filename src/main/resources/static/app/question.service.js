"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
const core_1 = require('@angular/core');
const dropdown_config_1 = require('./dropdown.config');
const text_config_1 = require('./text.config');
const question_panel_config_1 = require('./question-panel.config');
const checkbox_config_1 = require("./checkbox.config");
const textarea_config_1 = require("./textarea.config");
const yesno_config_1 = require("./yesno.config");
const autocomplete_config_1 = require("./autocomplete.config");
let QuestionService = class QuestionService {
    // Todo: get from MongoDB
    // Todo: make asynchronous
    getQuestions() {
        let questions = [
            new autocomplete_config_1.AutocompleteConfig({
                key: 'company',
                label: 'Previous Insurer',
                css: 'col-md-3',
                placeholder: 'enter insurer',
                choices: [
                    { key: '1', value: 'Wawanesa' },
                    { key: '2', value: 'Zurich' },
                    { key: '3', value: 'State Farm' },
                    { key: '5', value: 'Pembridge' },
                    { key: '6', value: 'Grenville' },
                    { key: '7', value: 'CAA' },
                    { key: '8', value: 'Great White Insurance' },
                    { key: '9', value: 'Gecko' }
                ],
                order: 7
            }),
            new dropdown_config_1.DropDownConfig({
                key: 'vehicleType',
                label: 'Vehicle Type',
                css: 'col-md-3',
                choices: [
                    { key: '1', value: 'GENERAL MOTORS' },
                    { key: '2', value: 'TOYOTA' },
                    { key: '3', value: 'MERCEDES BENZ' },
                    { key: '4', value: 'FIAT CHRYSLER' },
                    { key: '5', value: 'FORD' }
                ],
                order: 3
            }),
            new checkbox_config_1.CheckBoxConfig({
                key: 'underAge',
                label: 'Are you under 18?',
                css: 'col-md-3',
            }),
            new yesno_config_1.YesNoConfig({
                key: 'accident',
                label: 'Have you had an accident?',
                css: 'col-md-8',
                showWhen: [{ parent: 'underAge', value: true }]
            }),
            new textarea_config_1.TextAreaConfig({
                key: 'accidentDesc',
                label: 'Description',
                placeholder: 'Please describe the GMC accident',
                css: 'col-md-12',
                rows: 1,
                showWhen: [{ parent: 'accident', value: 'yes' },
                    { parent: 'vehicleType', value: '1' }]
            }),
            new question_panel_config_1.QuestionPanelConfig({
                children: [
                    new dropdown_config_1.DropDownConfig({
                        css: 'col-md-5',
                        key: 'country',
                        label: 'Country',
                        choices: [
                            { key: '1', value: 'Canada' },
                            { key: '2', value: 'USA' },
                            { key: '3', value: 'Mexico' },
                        ],
                    }),
                ],
                css: 'col-md-12',
                order: 4
            }),
            new text_config_1.TextConfig({
                key: 'firstName',
                css: 'col-md-3',
                label: 'First name',
                value: '',
                required: true,
                order: 1
            }),
            new text_config_1.TextConfig({
                key: 'emailAddress',
                css: 'col-md-2',
                label: 'Email',
                inputType: 'email',
                order: 2
            })
        ];
        // TODO : allow for null order. (or ensure order is a number)?
        return questions.sort((a, b) => a.order - b.order);
    }
    getMoreQuestions() {
        let questions = [
            new yesno_config_1.YesNoConfig({
                key: 'workDrive',
                label: 'Do you drive to work',
                css: 'col-md-8',
                order: 1
            }),
            new text_config_1.TextConfig({
                key: 'workDistance',
                css: 'col-md-offset-2 col-md-2',
                label: 'Distance',
                required: true,
                inputType: 'number',
                showWhen: [{ parent: 'workDrive', value: 'yes' }],
                order: 2
            }),
            new yesno_config_1.YesNoConfig({
                key: 'haveWork',
                label: 'Do you work?',
                css: 'col-md-6 col-md-offset-2',
                showWhen: [{ parent: 'workDrive', value: 'no' }],
                order: 3
            }),
            new yesno_config_1.YesNoConfig({
                key: 'mvr',
                label: 'Do you have MVR?',
                css: 'col-md-8',
                order: 4
            }),
            new dropdown_config_1.DropDownConfig({
                key: 'mvrStatus',
                label: 'MVR Status',
                css: 'col-md-3',
                choices: [
                    { key: '1', value: 'Ordered' },
                    { key: '2', value: 'Not Ordered' },
                    { key: '3', value: 'I Dunno' },
                ],
                order: 4
            }),
            new checkbox_config_1.CheckBoxConfig({
                key: 'convertible',
                label: 'The vehicle is a convertible',
                css: 'col-md-3',
                order: 5
            }),
            new yesno_config_1.YesNoConfig({
                key: 'original',
                label: 'Are you original owner?',
                css: 'col-md-8',
                order: 6,
                showWhen: [{ parent: 'convertible', value: true }]
            }),
            new autocomplete_config_1.AutocompleteConfig({
                key: 'color',
                label: 'What color is your vehicle',
                css: 'col-md-3',
                placeholder: 'enter a color',
                choices: [
                    { key: '1', value: 'red' },
                    { key: '2', value: 'green' },
                    { key: '3', value: 'blue' },
                    { key: '5', value: 'beige' },
                    { key: '6', value: 'sort of a pinkish brown' },
                    { key: '7', value: 'aqua marine' },
                    { key: '8', value: 'cobalt blue' },
                    { key: '9', value: 'turkish green' }
                ],
                order: 7
            }),
        ];
        // TODO : allow for null order. (or ensure order is a number)?
        return questions.sort((a, b) => a.order - b.order);
    }
};
QuestionService = __decorate([
    core_1.Injectable(), 
    __metadata('design:paramtypes', [])
], QuestionService);
exports.QuestionService = QuestionService;
//# sourceMappingURL=question.service.js.map