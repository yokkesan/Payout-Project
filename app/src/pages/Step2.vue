<template>
    <div class="page step2">
        <div class="page__container">

            <h1 class="step2__title">ワンタイムパスワード入力</h1>

            <h3 class="step2__subtitle">
                認証コード入力<br />
                <small>One Time Password Entry</small>
            </h3>

            <p class="step2__instruction">
                メールに届いた認証コードを入力してください。
            </p>

            <p class="step2__notice">
                ※認証コードの有効期限は30分です
            </p>

            <div class="step2__form">

                <input
                    v-model="code"
                    type="text"
                    maxlength="6"
                    inputmode="numeric"
                    placeholder="6桁コード"
                    class="step2__input"
                />

                <button
                    class="step2__submit"
                    :disabled="isSubmitting"
                    @click="verify"
                >
                    認証
                </button>

                <button
                    class="step2__back"
                    @click="router.push('/step1')"
                >
                    戻る
                </button>

            </div>

        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const code = ref('')
const isSubmitting = ref(false)

const verify = async () => {

    if (code.value.length !== 6) {
        alert('6桁のコードを入力してください')
        return
    }

    isSubmitting.value = true

    const email = localStorage.getItem('email')

    const res = await fetch(`${import.meta.env.VITE_API_BASE_URL}/api/auth/verify-code`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            email: email ?? '',
            code: code.value
        })
    })

    if (!res.ok) {
        alert('認証に失敗しました')
        isSubmitting.value = false
        return
    }

    router.push('/step3')
}
</script>