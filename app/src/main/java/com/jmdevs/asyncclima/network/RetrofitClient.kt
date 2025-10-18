package com.jmdevs.asyncclima.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Objeto singleton para crear y gestionar la instancia de Retrofit.
 */
object RetrofitClient {

    private const val BASE_URL = "https://api.open-meteo.com/"

    // 'lazy' asegura que la instancia de Retrofit se cree una sola vez y solo cuando se necesite.
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Exponemos el servicio de la API para que pueda ser usado desde otras partes de la app.
    val apiService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}
