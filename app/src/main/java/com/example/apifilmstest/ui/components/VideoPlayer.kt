package com.example.apifilmstest.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apifilmstest.api.rutube.Rutube.getPlayerUrl
import com.example.apifilmstest.api.rutube.entity.Result
import com.kevinnzou.web.WebView
import com.kevinnzou.web.rememberWebViewState

@Composable
fun VideoPlayer(
    movie: Result,
    modifier: Modifier = Modifier
) {
    val state = rememberWebViewState(movie.getPlayerUrl())
    WebView(
        modifier = modifier,
        state = state
    )
}