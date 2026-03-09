
<template>

    <div class="page top">
        <div class="page__container">

            <!-- タイトル -->
            <header class="top__header">
                <h1 class="top__title">規約同意</h1>
                <h3 class="top__subtitle">
                    規約同意<br />
                    <small>Terms of Use</small>
                </h3>
                <p class="top__description">
                    下記利用規約をご覧頂いた上、下記チェックボックスにチェックをお願い致します。
                </p>
            </header>

            <!-- 規約リンク -->
            <div class="top__terms">
                <p>
                    1.
                    <a href="/pdf/terms-primary.pdf" target="_blank">
                        NovaPay Prepaid 利用規約
                    </a>
                </p>
                <p>
                    2.
                    <a href="/pdf/terms-appendix.pdf" target="_blank">
                        利用規約_別紙
                    </a>
                </p>
            </div>

            <!-- 同意エリア -->
            <div class="top__form">
                <div class="top__checkbox">
                    <input type="checkbox" id="agree" v-model="agreed" />
                    <label for="agree">
                        上記の利用規約を確認し、NovaPay Prepaidに申込みます。
                    </label>
                </div>

                <div class="top__submit-wrap">
                    <button class="top__submit" :class="{ 'is-active': agreed }" :disabled="!agreed" @click="goStep1">
                        申し込む
                    </button>
                </div>
            </div>

        </div>
    </div>

    <!-- お問い合わせ帯 -->
    <section class="contact-band">
        <div class="contact-band__inner">

            <h2 class="contact-band__title">
                お問い合わせ
                <span>Contact</span>
            </h2>

            <p class="contact-band__text">
                より詳しい情報をご希望の方はご連絡ください
            </p>

            <div class="contact-band__buttons">
                <button class="contact-band__btn contact-band__btn--primary">
                    資料請求をする
                </button>

                <button class="contact-band__btn contact-band__btn--secondary">
                    お問い合わせはこちら
                </button>
            </div>

        </div>
    </section>


</template>


<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const agreed = ref(false)

const canSubmit = computed(() => agreed.value)

const goStep1 = () => {
  if (!canSubmit.value) return
  router.push('/step1')
}
</script>