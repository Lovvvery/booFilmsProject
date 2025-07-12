package com.example.apifilmstest.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.apifilmstest.api.themoviedb.MovieRepository
import com.example.apifilmstest.api.themoviedb.TMDbApi
import com.example.apifilmstest.data.MovieViewModel
import com.example.apifilmstest.ui.NavGraph
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TMDbApi::class.java)

        val viewModel = MovieViewModel(MovieRepository(api))

        setContent {
            NavGraph(viewModel = viewModel)
        }
    }
}