package com.jmdevs.asyncclima

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmdevs.asyncclima.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _weatherData = MutableLiveData<String>()
    val weatherData: LiveData<String> get() = _weatherData

    /**
     * Inicia la obtención de datos del clima desde la API real.
     */
    fun fetchWeatherData() {
        // Inicia una corrutina en el hilo principal.
        viewModelScope.launch {
            _isLoading.value = true

            try {
                // 'withContext(Dispatchers.IO)' cambia la ejecución a un hilo de fondo,
                // ideal para llamadas de red, evitando bloquear la UI.
                val weatherResponse = withContext(Dispatchers.IO) {
                    RetrofitClient.apiService.getWeatherData(latitude = -33.45, longitude = -70.66)
                }

                // Una vez que tenemos la respuesta, volvemos al hilo principal para
                // formatearla y actualizar el LiveData.
                val currentWeather = weatherResponse.currentWeather
                val resultText = """
                    Temperatura: ${currentWeather.temperature}°C
                    Velocidad del Viento: ${currentWeather.windSpeed} km/h
                """.trimIndent()

                _weatherData.value = resultText

            } catch (e: Exception) {
                // Si algo falla (ej. sin internet), mostramos un mensaje de error.
                _weatherData.value = "Error al cargar los datos: ${e.message}"
            } finally {
                // Independientemente del resultado, ocultamos el ProgressBar.
                _isLoading.value = false
            }
        }
    }
}
