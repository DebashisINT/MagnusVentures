package com.breezefieldmagnus.features.weather.api

import com.breezefieldmagnus.features.task.api.TaskApi
import com.breezefieldmagnus.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}