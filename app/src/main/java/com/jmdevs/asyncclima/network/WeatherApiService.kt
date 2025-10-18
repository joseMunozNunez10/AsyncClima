package com.jmdevs.asyncclima.network

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interfaz que define los endpoints de la API del clima para Retrofit.
 */
interface WeatherApiService {

    @GET("v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current_weather") currentWeather: Boolean = true
    ): WeatherResponse
}
