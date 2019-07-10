<template>
  <q-page class="flex flex-center">
    <div class="q-pa-md" style="max-width: 350px">
      <q-list bordered >
        <q-item-label header>LOCATION</q-item-label>

        <q-item>
          <q-item-section>
            <q-item-label>latitude</q-item-label>
          </q-item-section>
          <q-item-section side>
            <q-item-label>{{latitude}}</q-item-label>
          </q-item-section>
        </q-item>

        <q-item>
          <q-item-section>
            <q-item-label>longitude</q-item-label>
          </q-item-section>
          <q-item-section side>
            <q-item-label>{{longitude}}</q-item-label>
          </q-item-section>
        </q-item>

        <q-item>
          <q-item-section>
            <q-item-label>Plus Code</q-item-label>
          </q-item-section>
          <q-item-section side>
            <q-item-label>{{pluscode}}</q-item-label>
          </q-item-section>
        </q-item>

        <q-separator spaced />
        <q-item-label header>NETWORK</q-item-label>

        <q-item>
          <q-item-section>
            <q-item-label>WebSocket</q-item-label>
          </q-item-section>
          <q-item-section side>
            <q-item-label>fix_online</q-item-label>
          </q-item-section>
        </q-item>
      </q-list>
    </div>
  </q-page>
</template>

<style>
</style>

<script>
export default {
  name: 'PageIndex',
  computed: {
    latitude: function () {
      return this.$store.state.location.lat
    },
    longitude: function () {
      return this.$store.state.location.long
    },
    pluscode: function () {
      return this.$store.state.location.pluscode
    }
  }
}
</script>
