package com.breezefieldmagnus.features.viewAllOrder.interf

import com.breezefieldmagnus.app.domain.NewOrderGenderEntity
import com.breezefieldmagnus.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}