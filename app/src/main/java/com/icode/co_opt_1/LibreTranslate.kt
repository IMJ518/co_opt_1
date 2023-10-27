package com.icode.co_opt_1

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// Data Transfer Object(DTO) - define data structure for API communication
data class TranslateRequest(val q: String, val source: String, val target: String)
data class TranslateResponse(val translatedText: String)

// API Interface (define CRUD methods using GET, POST, PUT, DELETE annotations)
interface LibreTranslate {
    @POST("translate")
    fun translate(@Body request: TranslateRequest): Call<TranslateResponse>
}