package com.breezefieldmagnus.features.viewAllOrder.interf

import com.breezefieldmagnus.app.domain.NewOrderGenderEntity
import com.breezefieldmagnus.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}