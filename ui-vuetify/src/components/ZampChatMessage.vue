<template>

    <v-timeline-item 
      small
      fill-dot
      :color="computeMiddleBallColor"
      :left="computeShowLeft"
    >
      <v-card>
        <v-card-title class="lighten-2" :class="computeClassForCardTitleBackground">
          <v-icon dark size="18" class="mr-4">mdi-account-question</v-icon>
          <h2 class="subtitle-1 white--text font-weight-light">{{message.name}}</h2>
        </v-card-title>
        <v-container>
          <v-row>
            <v-col cols="12" md="10">{{message.message[0]}}</v-col>
            <v-col class="hidden-sm-and-down text-right" md="2">
              <v-icon size="64">mdi-calendar-text</v-icon>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-timeline-item>

</template>

  <!-- sent: means I have sent the message 
  <q-chat-message sent v-if="message.me==true" v-bind:name="message.name" :text="message.message" />
  <q-chat-message v-else v-bind:name="message.name" :text="message.message" />
  -->

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
  computed: {
    computeShowLeft() {
      if (this.message.me != true) {
        return true
      }
      return false
    },
    computeMiddleBallColor() {
      if (this.message.me != true) {
        return 'purple lighten-2'
      }
      return 'blue lighten-2'
    },
    computeClassForCardTitleBackground() {
      if (this.message.me != true) {
        return 'purple'
      }
      return 'blue'
    }
  },
  methods: {
    myDummyTrue() {
      return true
    },
  }
}
</script>