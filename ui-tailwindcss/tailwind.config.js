module.exports = {
  mode: 'jit',
  content: [
    "./**/*.html",
  ],
  theme: {
    backgroundImage: {
      'world-globus': "url('../img/bg_world_globus_1.jpg')",
    },
    extend: {
      fontSize: {
        'hero': '15rem',
      },
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
