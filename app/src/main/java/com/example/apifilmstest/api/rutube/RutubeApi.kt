package com.example.apifilmstest.api.rutube

import com.example.apifilmstest.api.rutube.entity.RutubeSearchData
import retrofit2.http.GET
import retrofit2.http.Query

interface RutubeApi {
    @GET("?category_id=4")
    suspend fun search(
        @Query("query") query: String
    ): RutubeSearchData
}