package com.breezefieldmagnus.features.viewAllOrder.interf

import com.breezefieldmagnus.app.domain.NewOrderColorEntity
import com.breezefieldmagnus.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}