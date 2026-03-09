<script setup lang="ts">
import { onMounted } from 'vue'
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'

onMounted(async () => {
  const res = await fetch('/api/health')
  const text = await res.text()
  console.log(text)
})
</script>

<template>
  <Header />
  <router-view />
  <Footer />
</template>　