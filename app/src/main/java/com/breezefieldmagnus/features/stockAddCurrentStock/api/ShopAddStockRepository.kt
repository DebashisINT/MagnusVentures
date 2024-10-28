package com.breezefieldmagnus.features.stockAddCurrentStock.api

import com.breezefieldmagnus.base.BaseResponse
import com.breezefieldmagnus.features.location.model.ShopRevisitStatusRequest
import com.breezefieldmagnus.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezefieldmagnus.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.breezefieldmagnus.features.stockAddCurrentStock.model.CurrentStockGetData
import com.breezefieldmagnus.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}