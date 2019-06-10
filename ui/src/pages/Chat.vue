<template>
  <q-page class="flex flex-center">
    <div class="q-pa-md">
      <!-- enter the nickname -->
      <div v-if="showNickSelect" class="row q-gutter-md">
        <div class="col-12">
           <q-input v-model="nickname" @input='handleNicknameInput' label="Nickname" :dense="dense" />
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
      isJoinDisabled: true,
      showNickSelect: true,
      nickname: '',
      chatHistory: [
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
      ]
    }
  },
  methods: {
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
