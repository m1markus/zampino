<template>
  <div class="about">
    <h1>This is an information page</h1>
    <p>vue: {{ vueVersion }}
    </p>
    <p>vuetify: {{ vuetifyVersion }}
    </p>
  </div>
</template>

<script>
//import vuetify from '@/plugins/vuetify';

export default {
    data: () => ({
        vueVersion: undefined,
        vuetifyVersion: 'x.x.x',
    }),
    mounted() {
        this.vueVersion = this.$store.state.software[0].version
        //this.vuetifyVersion = vuetify.version()
        //debugger
    }
}
</script>