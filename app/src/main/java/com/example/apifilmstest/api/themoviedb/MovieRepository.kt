package com.example.apifilmstest.api.themoviedb

class MovieRepository(private val api: TMDbApi) {
    suspend fun getPopularMovies(apiKey: String) = api.getPopularMovies(apiKey)
    suspend fun searchMovies(query: String, apiKey: String) = api.searchMovies(query, apiKey)
    suspend fun getMovieDetails(id: Int, apiKey: String) = api.getMovieDetails(id, apiKey)
}
