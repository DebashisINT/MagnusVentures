package com.breezefieldmagnus.features.location.shopRevisitStatus

import com.breezefieldmagnus.features.location.shopdurationapi.ShopDurationApi
import com.breezefieldmagnus.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}