<template>
  <!-- sent: means I have sent the message -->
  <q-chat-message sent v-if="message.me==true" v-bind:name="message.name" :text="message.message" />
  <q-chat-message v-else v-bind:name="message.name" :text="message.message" />
</template>

<style>
</style>

<script>
export default {
  name: 'ZampChatMessage',
  props: ['message'],
  data: function () {
    return {
      dummy: false
    }
  },
  methods: {
    dummyFunc1: function () {
    }
  }
}
</script>
