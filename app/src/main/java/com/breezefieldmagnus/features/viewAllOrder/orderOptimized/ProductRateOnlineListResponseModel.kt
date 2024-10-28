package com.breezefieldmagnus.features.viewAllOrder.orderOptimized

import com.breezefieldmagnus.app.domain.ProductOnlineRateTempEntity
import com.breezefieldmagnus.base.BaseResponse
import com.breezefieldmagnus.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}