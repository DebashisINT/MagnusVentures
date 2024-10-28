package com.breezefieldmagnus.features.viewAllOrder.interf

import com.breezefieldmagnus.app.domain.NewOrderGenderEntity
import com.breezefieldmagnus.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}