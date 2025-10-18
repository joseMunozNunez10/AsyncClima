package com.jmdevs.asyncclima

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jmdevs.asyncclima.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.reloadButton.setOnClickListener {
            mainViewModel.fetchWeatherData()
        }

        mainViewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.reloadButton.isEnabled = !isLoading
        }

        mainViewModel.weatherData.observe(this) { data ->
            binding.weatherTextView.text = data
        }
    }
}
