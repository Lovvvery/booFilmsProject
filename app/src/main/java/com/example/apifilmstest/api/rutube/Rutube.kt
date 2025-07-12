package com.example.apifilmstest.api.rutube

import com.example.apifilmstest.api.rutube.entity.Result
import com.example.apifilmstest.api.rutube.entity.RutubeSearchData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rutube {
    private const val BASE_URL = "https://rutube.ru/api/search/video/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RutubeApi::class.java)

    suspend fun search(query: String): RutubeSearchData {
        return api.search(query)
    }

    fun Result.getPlayerUrl() = this.embed_url
}