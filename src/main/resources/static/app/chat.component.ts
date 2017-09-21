import { Component } from '@angular/core';
// import Stomp from 'stompjs';
// import * as SockJS from 'sockjs-client';

// var SockJS = require('sockjs-client');
// var Stomp = require('stompjs');

@Component({
    selector: 'chat',
    templateUrl: '/app/chat.component.html'
})
export class ChatComponent {

    stompClient:Stomp;
    from:string;
    to:string;
    text:string;
    msgs:any[] = [];

    constructor() {
    }

    public connect(user:string) :void {
        var socket = new SockJS('/chat');
        this.stompClient = Stomp.over(socket);
        this.from = user;
        this.stompClient.connect({},this.onConnect.bind(this));
    }

    public onConnect(frame:any) :void {
        console.log('Connected: ' + frame);
        this.stompClient.subscribe('/topic/messages/'+this.from, this.addMessage.bind(this));
    }

    public addMessage(message:any) {
        var msg = JSON.parse(message.body);
        this.msgs.push(msg);
        console.log('got message ' + msg.from + ' --> ' + msg.text );
    }

    public disconnect() :void {
        if (this.stompClient != null) {
            this.stompClient.disconnect();
            this.stompClient = null;
        }
        console.log("Disconnected");
    }

    public send(from:string, to:string, text:string) :void {
        this.stompClient.send("/chat/"+to, {}, JSON.stringify(
            {'from': from, text:text }
        ));
    }

    public isConnected() : boolean {
        return this.stompClient != null;
    }

    public fromChanged(v) : void {
        if (!v) return;
        console.log("connecting...");
        if (this.isConnected() && v!=this.from) {
            console.log("but disconnecting first!");
            this.disconnect();
        }
        this.connect(v);
    }

}
