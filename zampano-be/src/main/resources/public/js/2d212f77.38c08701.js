(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["2d212f77"],{ab55:function(e,s,a){"use strict";a.r(s);var t=function(){var e=this,s=e.$createElement,a=e._self._c||s;return a("q-page",{staticClass:"flex flex-center"},[a("div",{staticClass:"q-pa-md"},[e.showNickSelect?a("div",{staticClass:"row q-gutter-md"},[a("div",{staticClass:"col-12"},[a("q-input",{attrs:{label:"Nickname"},on:{input:e.handleNicknameInput},model:{value:e.nickname,callback:function(s){e.nickname=s},expression:"nickname"}})],1),a("div",{staticClass:"col-12"},[a("q-btn",{attrs:{disable:e.isJoinDisabled,color:"primary",label:"Join","no-caps":""},on:{click:e.handleJoin}})],1)]):e._e(),e.showNickSelect?e._e():a("div",{staticClass:"q-pa-md row justify-center"},[a("div",{staticStyle:{width:"100%","max-width":"400px"}},e._l(e.chatHistory,function(e){return a("zamp-chat-message",{key:e.id,attrs:{message:e}})}),1),a("div",{staticClass:"row q-gutter-md"},[a("q-input",{attrs:{outlined:"",label:"Your message"},model:{value:e.nextMessage,callback:function(s){e.nextMessage=s},expression:"nextMessage"}}),a("q-btn",{attrs:{color:"primary",label:"Send","no-caps":""},on:{click:e.handleSend}})],1)])])])},n=[],i=(a("7f7f"),function(){var e=this,s=e.$createElement,a=e._self._c||s;return 1==e.message.me?a("q-chat-message",{attrs:{sent:"",name:e.message.name,text:e.message.message}}):a("q-chat-message",{attrs:{name:e.message.name,text:e.message.message}})}),o=[],c={name:"ZampChatMessage",props:["message"],data:function(){return{dummy:!1}},methods:{dummyFunc1:function(){}}},l=c,m=a("2877"),r=Object(m["a"])(l,i,o,!1,null,null,null),d=r.exports,u={name:"Chat",data:function(){return{ws:void 0,isJoinDisabled:!0,showNickSelect:!0,nickname:"",nextMessage:"",messageIndex:0,chatHistory:[]}},mounted:function(){var e=new WebSocket("ws://localhost:8080/api/v1/wsocket"),s=this.chatHistory;e.onmessage=function(e){console.log("new peer message received:",e.data);var a=JSON.parse(e.data),t={id:this.messageIndex++,me:!1,name:a.name,message:a.message};s.push(t)},e.onerror=function(e){console.error("WebSocket error observed:",e)},e.onopen=function(e){console.log("WebSocket is open now:",e)},e.onclose=function(e){console.log("WebSocket is closed now:",e)},this.ws=e},methods:{handleSend:function(){this.addLocalMessage()},addRemoteMessage:function(){},addLocalMessage:function(){var e={id:this.messageIndex++,me:!0,name:this.nickname,message:[this.nextMessage]};this.chatHistory.push(e);var s=JSON.stringify(e);this.ws.send(s)},handleJoin:function(){""!==this.nickname&&(this.showNickSelect=!1)},handleNicknameInput:function(e){if(void 0!==e){var s=e.length;this.isJoinDisabled=!(s>0)}}},components:{"zamp-chat-message":d}},h=u,g=Object(m["a"])(h,t,n,!1,null,null,null);s["default"]=g.exports}}]);