import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

Vue.version

export default new Vuex.Store({
  state: {

    software: [
      { component: 'vue', version: Vue.version },
    ]
  },
  mutations: {

  },
  actions: {

  }
})
