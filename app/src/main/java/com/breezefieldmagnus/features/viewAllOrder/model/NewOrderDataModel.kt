package com.breezefieldmagnus.features.viewAllOrder.model

import com.breezefieldmagnus.app.domain.NewOrderColorEntity
import com.breezefieldmagnus.app.domain.NewOrderGenderEntity
import com.breezefieldmagnus.app.domain.NewOrderProductEntity
import com.breezefieldmagnus.app.domain.NewOrderSizeEntity
import com.breezefieldmagnus.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

