package com.breezefieldmagnus.features.weather.api

import com.breezefieldmagnus.base.BaseResponse
import com.breezefieldmagnus.features.task.api.TaskApi
import com.breezefieldmagnus.features.task.model.AddTaskInputModel
import com.breezefieldmagnus.features.weather.model.ForeCastAPIResponse
import com.breezefieldmagnus.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}