package com.example.apifilmstest.api.themoviedb.entity

data class MovieResponse(val results: List<Movie>)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?
)


data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val release_date: String,
    val vote_average: Float
)
