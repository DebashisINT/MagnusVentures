package com.breezefieldmagnus.features.login.model.productlistmodel

import com.breezefieldmagnus.app.domain.NewOrderScrOrderEntity
import com.breezefieldmagnus.app.domain.ProductListEntity

class NewOdrScrOrderListModel {
    var status:String? = null
    var message:String? = null
    var user_id:String? = null
    var order_list: ArrayList<NewOrderScrOrderEntity>? = null
}