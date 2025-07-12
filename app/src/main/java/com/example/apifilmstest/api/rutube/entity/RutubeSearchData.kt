package com.example.apifilmstest.api.rutube.entity

data class RutubeSearchData(
    val count: Int,
    val current_page: Int,
    val has_next: Boolean,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)