<template>
  <q-page class="flex flex-center">
    <!--
    <img alt="Quasar logo" src="~assets/quasar-logo-full.svg">
    -->
    <div class="col-12">
      <div id="chat" class="row">
        <div class="col-12">
        <q-chat-message label="Sunday, 19th"/>

        <q-chat-message
          name="me-1"
          avatar="statics/boy-avatar.png"
          :text="['hunter2']"
          stamp="4 minutes ago"
          sent
        />

        <q-chat-message
          name="Jane"
          avatar="statics/linux-avatar.png"
          :text="['hey, if you type in your pw', 'it will show as stars']"
          stamp="7 minutes ago"
        />
        </div>
      </div>

      <div class="row">
          <q-field icon="cloud" label="Your Gmail" helper="Helper">
            <q-input suffix="@gmail.com" v-model="model" color="yellow"/>
          </q-field>
      </div>

    </div>

  </q-page>
</template>

<style>
</style>

<script>
export default {
  name: 'PageIndex'
}
</script>
