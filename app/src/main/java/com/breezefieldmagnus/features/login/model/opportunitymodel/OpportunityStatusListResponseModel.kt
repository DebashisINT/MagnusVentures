package com.breezefieldmagnus.features.login.model.opportunitymodel

import com.breezefieldmagnus.app.domain.OpportunityStatusEntity
import com.breezefieldmagnus.app.domain.ProductListEntity
import com.breezefieldmagnus.base.BaseResponse

/**
 * Created by Puja on 30.05.2024
 */
class OpportunityStatusListResponseModel : BaseResponse() {
    var status_list: ArrayList<OpportunityStatusEntity>? = null
}