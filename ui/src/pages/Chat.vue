<template>
  <q-page class="flex flex-center">
    <div class="q-pa-md">
      <!-- enter the nickname -->
      <div v-if="showNickSelect" class="row q-gutter-md">
        <div class="col-12">
           <q-input v-model="nickname" @input='handleNicknameInput' label="Nickname" />
        </div>
        <div class="col-12">
            <q-btn :disable="isJoinDisabled" @click='handleJoin' color="primary" label="Join" no-caps />
        </div>
      </div>
      <div v-if="!showNickSelect" class="q-pa-md row justify-center">
        <div style="width: 100%; max-width: 400px">
            <zamp-chat-message v-for="msg in chatHistory" v-bind:key="msg.id" v-bind:message="msg"/>
          <!--
          <zamp-chat-message />
          <q-chat-message name="Mex" :text="['hey, how are you?']" sent />
          <q-chat-message name="Jane" :text="['doing fine, how r you?', 'hey', 'men']" />
          <q-chat-message sent name="me" :text="['hey everybody']" />
          -->
        </div>
        <div class="row q-gutter-md">
          <q-input outlined v-model="nextMessage" label="Your message" />
          <q-btn  @click='handleSend' color="primary" label="Send" no-caps />
        </div>
      </div>
    </div>
  </q-page>
</template>

<style>
</style>

<script>
import ZampChatMessage from '../components/ZampChatMessage'

export default {
  name: 'Chat',
  data: function () {
    return {
      ws: undefined,
      isJoinDisabled: true,
      showNickSelect: true,
      nickname: '',
      nextMessage: '',
      messageIndex: 0,
      chatHistory: [
        /*
        { id: '1', me: true, name: 'Markus', message: ['hey you'] },
        { id: '2', me: false, name: 'Sandy', message: ['I love you'] },
        { id: '3', me: true, name: 'Markus', message: ['I love you too'] },
        { id: '4', me: true, name: 'Markus', message: ['hey you'] },
        { id: '5', me: false, name: 'Sandy', message: ['I love you'] },
        { id: '6', me: true, name: 'Markus', message: ['I love you too'] },
        { id: '7', me: true, name: 'Markus', message: ['hey you'] },
        { id: '8', me: false, name: 'Sandy', message: ['I love you'] },
        { id: '9', me: true, name: 'Markus', message: ['I love you too'] },
        { id: '10', me: true, name: 'Markus', message: ['hey you'] },
        { id: '11', me: false, name: 'Sandy', message: ['I love you'] },
        { id: '12', me: true, name: 'Markus', message: ['I love you too'] },
        { id: '13', me: false, name: 'Sandy', message: ['this', 'is e very very very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong line', 'it'] }
        */
      ]
    }
  },
  mounted: function () {
    let ws = new WebSocket('ws://localhost:8080/api/v1/wsocket')
    ws.onmessage = function (data) {
      console.log('new peer message received:', data)
    }
    ws.onerror = function (event) {
      console.error('WebSocket error observed:', event)
    }
    ws.onopen = function (event) {
      console.log('WebSocket is open now:', event)
    }
    ws.onclose = function (event) {
      console.log('WebSocket is closed now:', event)
    }
    this.ws = ws
  },
  methods: {
    handleSend: function () {
      // let msg = 'try to send: ' + this.nextMessage
      // alert(msg)
      this.addLocalMessage()
    },
    addRemoteMessage: function () {

    },
    addLocalMessage: function () {
      // { id: '11', me: true, name: 'Markus', message: ['I love you'] },
      let message = {
        id: this.messageIndex++,
        me: true,
        name: this.nickname,
        // don't forget, this is an array of messages
        message: [this.nextMessage]
      }
      this.chatHistory.push(message)
      let msg = JSON.stringify(message)
      this.ws.send(msg)
      // alert(JSON.stringify(message))
    },
    handleJoin: function () {
      if (this.nickname !== '') {
        this.showNickSelect = false
      }
    },
    handleNicknameInput: function (value) {
      // console.log('change detected for nickname: ' + value)
      if (value !== undefined) {
        let n = value.length
        if (n > 0) {
          this.isJoinDisabled = false
        } else {
          this.isJoinDisabled = true
        }
      }
    }
  },
  components: {
    'zamp-chat-message': ZampChatMessage
  }
}
</script>
