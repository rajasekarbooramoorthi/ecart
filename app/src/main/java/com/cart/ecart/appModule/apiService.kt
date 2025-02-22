package com.cart.ecart.appModule
 import retrofit2.Response
 import retrofit2.http.GET


interface apiService {

    @GET("now_playing")
    suspend fun fetchMovies(): Response<MovieResponse>

}