<template>

    <v-timeline-item
      color="purple lighten-2"
      fill-dot
      right
    >
      <v-card>
        <v-card-title class="purple lighten-2">
          <v-icon
            dark
            size="42"
            class="mr-4"
          >
            mdi-magnify
          </v-icon>
          <h2 class="display-1 white--text font-weight-light">Title 1</h2>
        </v-card-title>
        <v-container>
          <v-row>
            <v-col cols="12" md="10">
              Why is this message so short.
            </v-col>
            <v-col
              class="hidden-sm-and-down text-right"
              md="2"
            >
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
  methods: {
    dummyFunc1: function () {
    }
  }
}
</script>