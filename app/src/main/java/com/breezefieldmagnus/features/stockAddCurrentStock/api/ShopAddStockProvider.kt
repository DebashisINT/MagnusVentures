package com.breezefieldmagnus.features.stockAddCurrentStock.api

import com.breezefieldmagnus.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezefieldmagnus.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}