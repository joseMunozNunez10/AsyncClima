package com.jmdevs.asyncclima.network

import com.google.gson.annotations.SerializedName

/**
 * Representa la respuesta completa de la API de Open-Meteo.
 */
data class WeatherResponse(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather
)

/**
 * Representa el objeto "current_weather" que contiene los datos del clima.
 */
data class CurrentWeather(
    @SerializedName("temperature")
    val temperature: Double,

    @SerializedName("windspeed")
    val windSpeed: Double,

    @SerializedName("weathercode")
    val weatherCode: Int
)
