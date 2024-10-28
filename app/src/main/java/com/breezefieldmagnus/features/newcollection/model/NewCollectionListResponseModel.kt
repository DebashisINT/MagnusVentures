package com.breezefieldmagnus.features.newcollection.model

import com.breezefieldmagnus.app.domain.CollectionDetailsEntity
import com.breezefieldmagnus.base.BaseResponse
import com.breezefieldmagnus.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}