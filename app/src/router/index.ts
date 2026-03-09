import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'top', component: () => import('../pages/Top.vue') },
    { path: '/step1', name: 'step1', component: () => import('../pages/Step1.vue') },
    { path: '/step2', name: 'step2', component: () => import('../pages/Step2.vue') },
  ],
})

export default router