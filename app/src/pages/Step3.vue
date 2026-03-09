<template>
    <div class="page step3">
        <div class="page__container">

            <h1 class="step3__title">
                個人情報取扱
            </h1>

            <div class="step3__form">

                <fieldset>

                    <p>
                        <label class="label">
                            <span class="required">必須</span>
                            個人情報取扱
                        </label><br />

                        <span class="wpcf7-form-control-wrap">
                            <span class="wpcf7-form-control wpcf7-checkbox wpcf7-validates-as-required">
                                <span class="wpcf7-list-item">

                                    <input type="checkbox" v-model="agree" />

                                    <span class="wpcf7-list-item-label">
                                        個人情報の取扱いについて同意する
                                    </span>

                                </span>
                            </span>
                        </span>

                    </p>

                    <p class="information-text">
                        <br />
                        下記内容を確認し、ご同意いただけましたらチェックしてから「送信」ボタンを押してください。
                    </p>

                    <div class="information-text information-title">
                        <p>
                            「ドコツーAI MIXプリペイド・お客様情報入力における個人情報の取扱いについて」
                        </p>
                    </div>

                    <ol class="information-text information-list">

                        <li>組織の名称又は氏名：株式会社サンプルボックス</li>

                        <li>個人情報保護管理者：サンプル</li>

                        <li>
                            個人情報の利用目的：サービス利用の対する請求先情報の確認のため
                        </li>

                        <li>
                            個人情報の第三者提供について：
                            取得した個人情報は法令等による場合を除いて第三者に提供することはありません。
                        </li>

                        <li>
                            個人情報の取扱いの委託について：
                            取得した個人情報を請求のため一部を委託することがあります。
                        </li>

                        <li>
                            個人情報を与えなかった場合に生じる結果：
                            サービス提供の契約ができません。
                        </li>

                        <li>
                            保有個人データの開示等および問合せ窓口：
                            ご本人からの求めにより、当社が保有する保有個人データに関する開示、
                            利用目的の通知、内容の訂正・追加または削除、利用停止、消去、
                            第三者提供の停止および第三者提供記録の開示に応じます。
                        </li>

                        <li>
                            本人が容易に認識できない方法による個人情報の取得：
                            クッキーを使用しています。使用禁止にされている場合はサービスが提供できません。
                        </li>

                        <li>
                            個人情報保護方針：
                            当社ホームページの個人情報保護方針をご覧下さい。
                        </li>

                        <li>
                            当社の個人情報の取扱いに関する苦情、相談等の問合せ先：
                            当社ホームページの個人情報保護方針をご覧下さい。
                        </li>

                    </ol>

                </fieldset>

                <div class="step3__buttons">

                    <button class="step3__submit" :disabled="!agree">
                        送信
                    </button>

                    <button class="step3__back" @click="router.push('/step2')">
                        戻る
                    </button>

                </div>

            </div>

        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const agree = ref(false)
</script>