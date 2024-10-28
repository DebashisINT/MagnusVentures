package com.breezefieldmagnus.features.login.model.productlistmodel

import com.breezefieldmagnus.app.domain.ModelEntity
import com.breezefieldmagnus.app.domain.ProductListEntity
import com.breezefieldmagnus.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}