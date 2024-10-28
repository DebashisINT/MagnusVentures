package com.breezefieldmagnus.features.dashboard.presentation.api.dayStartEnd

import com.breezefieldmagnus.features.stockCompetetorStock.api.AddCompStockApi
import com.breezefieldmagnus.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}