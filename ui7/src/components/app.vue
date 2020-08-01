<template>
<f7-app :params="f7params" >
  <!-- Status bar overlay for fullscreen mode-->
  <f7-statusbar></f7-statusbar>

  <!-- Left panel with cover effect-->
  <f7-panel left cover>
    <f7-view>
      <f7-page>
        <!--
        <f7-navbar title="Quick menu"></f7-navbar>

        <f7-block>Left panel content goes here</f7-block>
        
        <f7-block-title>Simple Links List</f7-block-title>
        -->
        <f7-list>
          <f7-list-item title="About" link="/about/" view=".view-main"></f7-list-item>
          <f7-list-item title="Form" link="/form/" view=".view-main"></f7-list-item>
          <f7-list-item title="About 3" link="/about" ></f7-list-item>
        </f7-list>
      </f7-page>
    </f7-view>
  </f7-panel>

  <!-- Your main view, should have "view-main" class -->
  <f7-view main class="safe-areas" url="/"></f7-view>

</f7-app>
</template>

<script>

  import routes from '../js/routes.js';

  export default {
    data() {
      return {
        // Framework7 Parameters
        f7params: {
          name: 'Zampano', // App name
          theme: 'auto', // Automatic theme detection
          // App root data
          data: function () {
            return {
              user: {
                firstName: 'John',
                lastName: 'Doe',
              },

            };
          },

          // App routes
          routes: routes
        }
      }
    },
    methods: {
      alertLoginData() {
        this.$f7.dialog.alert('Username: ' + this.username + '<br>Password: ' + this.password);
      }
    },
    mounted() {
      this.$f7ready((f7) => {
        // Call F7 APIs here
      });
    }
  }
</script>