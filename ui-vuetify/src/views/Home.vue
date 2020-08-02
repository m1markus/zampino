<template>
    <v-container class="grey lighten-3">
      <v-row v-if="showNickSelect">
        <v-col>
          <v-text-field label="Your nickname goes here"></v-text-field>
        </v-col>
      </v-row>
      <v-row v-if="showNickSelect">
        <v-col cols="1">
          <v-btn class="ma-1" rounded outlined color="indigo">Join</v-btn>
        </v-col>
      </v-row>

      <v-row v-if="!showNickSelect">
        <v-col cols="12">
          <v-timeline :dense="$vuetify.breakpoint.sxOnly">
            <zamp-chat-message v-for="msg in chatHistory" v-bind:key="msg.id" v-bind:message="msg"/>
          </v-timeline>
        </v-col>
      </v-row>

    </v-container>
</template>

<script>
import ZampChatMessage from '../components/ZampChatMessage'

export default {
  name: 'Chat',
  data: function () {
    return {
      ws: undefined,
      showNickSelect: false,
      isJoinDisabled: true,
      nickname: '',
      nextMessage: '',
      messageIndex: 0,
      chatHistory: [
        
        { id: '1', me: true, name: 'Markus', message: ['hey you'] },
        { id: '2', me: false, name: 'Sandy', message: ['I love you'] },

        /*
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
  mounted: function() {
    console.log('HOME got mounte')
    console.log('HOME got mounted, vuetify breakpoint: sxOnly' + $vuetify.breakpoint.sxOnly)
  },
  components: {
    'zamp-chat-message': ZampChatMessage
  }
}

</script>
