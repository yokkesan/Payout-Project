
<template>
    <div class="page step1">
        <div class="page__container">

            <h1 class="step1__title">メールアドレス入力</h1>

            <h3 class="step1__subtitle">
                メールアドレス入力<br />
                <small>Enter your email address</small>
            </h3>

            <p class="step1__instruction">
                メールアドレスを入力して「確認メール送信」ボタンをクリックしてください。
            </p>

            <div class="step1__form">
                <input v-model="email" type="email" maxlength="250" placeholder="メールアドレスを入力してください" class="step1__input"
                    required />
                <p class="step1__notice">
                    ※確認メールが届かない場合は、迷惑メールフォルダをご確認ください。
                </p>

                <button type="button" class="step1__submit" :disabled="isSubmitting" @click="goNext">
                    確認メール送信
                </button>

            </div>

        </div>

    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const email = ref('')
const isSubmitting = ref(false)

const goNext = async () => {

    if (!email.value) return

    isSubmitting.value = true

    const res = await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/auth/send-code`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            email: email.value
        })
    })

    if (res.status === 429) {
        alert('認証コードは1分後に再送できます')
        isSubmitting.value = false
        return
    }

    if (!res.ok) {
        alert('送信に失敗しました')
        isSubmitting.value = false
        return
    }

    localStorage.setItem('email', email.value)

    router.push('/step2')
}
</script>