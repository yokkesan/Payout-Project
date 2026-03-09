<template>

<header class="header">

    <!-- 上段 -->
    <div class="header__top">
        <div class="header__inner">

            <div class="header__logo">
                <span class="logo-mark">NB</span>
                <span class="logo-text">
                    NOVA BOX
                    <small>株式会社ノヴァボックス</small>
                </span>
            </div>

            <!-- ハンバーガー -->
                <button class="header__hamburger" :class="{ 'is-open': menuOpen }" @click="toggleMenu">
                <span></span>
                <span></span>
                <span></span>
            </button>

            <nav class="header__nav" :class="{ 'is-open': menuOpen }">
                <a href="#">導入事例</a>
                <a href="#">会社概要</a>
                <a href="#">採用情報</a>
                <a href="#">パートナー募集</a>
                <button class="header__contact">
                    お問い合わせ
                </button>
            </nav>

        </div>
    </div>

    <!-- 下段 -->
    <div class="header__bottom" :class="{ 'is-open': menuOpen }">
        <div class="header__inner">
            <nav class="header__services">
                <a href="#">①サンプルサービス</a>
                <a href="#">②サンプルサービス</a>
                <a href="#">③サンプルサービス</a>
                <a href="#">④サンプルサービス</a>
                <a href="#">⑤サンプルサービス</a>
            </nav>
        </div>
    </div>

</header>

</template>

<script setup>
import { ref } from 'vue'

const menuOpen = ref(false)

const toggleMenu = () => {
  menuOpen.value = !menuOpen.value
}
</script>