<template>
    <v-container class="grey lighten-3">
      <v-row>
        <v-col cols="4">
          <span>vue:</span>
        </v-col>
        <v-col cols="8">
          <span>{{ vueVersion }}</span>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="4">
          <span>vuetify:</span>
        </v-col>
        <v-col cols="8">
          <span>{{ vuetifyVersion }}</span>
        </v-col>
      </v-row>
    </v-container>
</template>

<script>
//import Vue from 'vue';

export default {
    data: () => ({
        vueVersion: undefined,
        vuetifyVersion: 'x.y.z',
    }),
    mounted() {
        this.vueVersion = this.$store.state.software[0].version
        //this.vuetifyVersion = Vue.prototype.$vuetify.version
        //debugger
    }
}
</script>
