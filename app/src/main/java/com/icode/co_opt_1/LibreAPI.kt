package com.icode.co_opt_1

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LibreAPI {
    @POST("translate")
    fun translateText(@Body request: TranslateRequest): Call<TranslateResponse>
}

data class TranslateRequest(val q: String, val source: String, val target: String)
data class TranslateResponse(val translatedText: String)
