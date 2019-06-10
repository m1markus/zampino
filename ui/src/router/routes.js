
const routes = [
  {
    path: '/',
    component: () => import('layouts/MyLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Chat.vue') },
      { path: 'settings', component: () => import('pages/Settings.vue') },
      { path: 'info', component: () => import('pages/Info.vue') },
      { path: 'development', component: () => import('pages/Development.vue') }
    ]
  }
]

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}

export default routes
