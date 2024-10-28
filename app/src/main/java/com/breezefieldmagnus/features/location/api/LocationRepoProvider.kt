package com.breezefieldmagnus.features.location.api

import com.breezefieldmagnus.features.location.shopdurationapi.ShopDurationApi
import com.breezefieldmagnus.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}