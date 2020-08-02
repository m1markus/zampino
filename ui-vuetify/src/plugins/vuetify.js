import Vue from 'vue';
// use the vuetify-loader
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

const opts = {
  icons: {
    iconfont: 'mdi',
  },
};

export default new Vuetify(opts);
