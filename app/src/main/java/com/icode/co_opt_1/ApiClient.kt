package com.icode.co_opt_1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://libretranslate.de/" // or another LibreTranslate instance URL

    val instance: LibreAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(LibreAPI::class.java)
    }
}
