package com.example.apifilmstest.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apifilmstest.api.themoviedb.entity.Movie
import com.example.apifilmstest.api.themoviedb.entity.MovieDetail
import com.example.apifilmstest.api.themoviedb.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _movieDetail = MutableStateFlow<MovieDetail?>(null)
    val movieDetail: StateFlow<MovieDetail?> = _movieDetail

    private val apiKey = "8389718597b56455bd1899a698962bf5"

    init {
        viewModelScope.launch {
            _movies.value = repository.getPopularMovies(apiKey).results
        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch {
            _movies.value = if (query.isBlank()) {
                repository.getPopularMovies(apiKey).results
            } else {
                repository.searchMovies(query, apiKey).results
            }
        }
    }

    fun loadMovieDetails(id: Int) {
        viewModelScope.launch {
            _movieDetail.value = repository.getMovieDetails(id, apiKey)
        }
    }
}