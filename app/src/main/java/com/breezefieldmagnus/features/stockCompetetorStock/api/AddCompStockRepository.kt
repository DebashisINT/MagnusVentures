package com.breezefieldmagnus.features.stockCompetetorStock.api

import com.breezefieldmagnus.base.BaseResponse
import com.breezefieldmagnus.features.orderList.model.NewOrderListResponseModel
import com.breezefieldmagnus.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.breezefieldmagnus.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}