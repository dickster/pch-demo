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
// import Stomp from 'stompjs';
// import * as SockJS from 'sockjs-client';
// var SockJS = require('sockjs-client');
// var Stomp = require('stompjs');
let ChatComponent = class ChatComponent {
    constructor() {
        this.msgs = [];
    }
    connect(user) {
        var socket = new SockJS('/chat');
        this.stompClient = Stomp.over(socket);
        this.from = user;
        this.stompClient.connect({}, this.onConnect.bind(this));
    }
    onConnect(frame) {
        console.log('Connected: ' + frame);
        this.stompClient.subscribe('/topic/messages/' + this.from, this.addMessage.bind(this));
    }
    addMessage(message) {
        var msg = JSON.parse(message.body);
        this.msgs.push(msg);
        console.log('got message ' + msg.from + ' --> ' + msg.text);
    }
    disconnect() {
        if (this.stompClient != null) {
            this.stompClient.disconnect();
            this.stompClient = null;
        }
        console.log("Disconnected");
    }
    send(from, to, text) {
        this.stompClient.send("/chat/" + to, {}, JSON.stringify({ 'from': from, text: text }));
    }
    isConnected() {
        return this.stompClient != null;
    }
    fromChanged(v) {
        if (!v)
            return;
        console.log("connecting...");
        if (this.isConnected() && v != this.from) {
            console.log("but disconnecting first!");
            this.disconnect();
        }
        this.connect(v);
    }
};
ChatComponent = __decorate([
    core_1.Component({
        selector: 'chat',
        templateUrl: '/app/chat.component.html'
    }), 
    __metadata('design:paramtypes', [])
], ChatComponent);
exports.ChatComponent = ChatComponent;
//# sourceMappingURL=chat.component.js.map