<template>
  <nav>
    <v-app-bar flat app>
      <v-btn color="secondary" class="mr-3" depressed fab text small @click="$router.go(-1)">
        <v-icon >mdi-chevron-left</v-icon>
      </v-btn>
      <v-toolbar-title class="grey--text">
        <span>ZAMP</span>
        <span class="font-weight-light">ANO</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>

      <v-app-bar-nav-icon class="grey--text" @click="drawer = !drawer"></v-app-bar-nav-icon>

      <!--
      <v-btn @click="$router.go(-1)">
        <span>Sign Out</span>
        <v-icon right>exit_to_app</v-icon>
      </v-btn> -->
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" app right >
      <v-list dense nav>
        <v-list-item-group color="grey">
          <v-list-item class v-for="link in links" :key="link.title" route :to="link.route">
            <v-list-item-icon>
              <v-icon>{{ link.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title class>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      drawer: false,
      links: [
        { icon: "dashboard", text: "Home", route: "/" },
        { icon: "dashboard", text: "Info", route: "/info" },
        { icon: "dashboard", text: "About", route: "/about" }
      ]
    };
  }
};
</script>

<style scoped>
/*
.v-list-item {
  background-color: green;
}
*/
</style>
