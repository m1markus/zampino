//import NotFoundPage from '../pages/404.vue';


var routes = [
  {
    path: '/',
    component: () => import('../pages/Chat.vue'),
  },
  {
    path: '/about',
    component: () => import('../pages/about.vue'),
  },  
  {
    path: '/info',
    component: () => import('../pages/Settings.vue'),
  },
  {
    path: '/development',
    component: () => import('../pages/Settings.vue'),
  },
  {
    path: '/settings',
    component: () => import('../pages/Settings.vue'),
  }
  /*
    children: [
      { path: '', component: () => import('pages/Chat.vue') },
      { path: 'settings', component: () => import('pages/Settings.vue') },
      { path: 'info', component: () => import('pages/Info.vue') },
      { path: 'development', component: () => import('pages/Development.vue') },
      {
        path: '(.*)',
        component: NotFoundPage,
      }
    ]
  } */
]

// Always leave this as last one
/*
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}
*/
export default routes;
