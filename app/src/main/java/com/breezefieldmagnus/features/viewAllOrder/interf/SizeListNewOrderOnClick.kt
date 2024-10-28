package com.breezefieldmagnus.features.viewAllOrder.interf

import com.breezefieldmagnus.app.domain.NewOrderProductEntity
import com.breezefieldmagnus.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}