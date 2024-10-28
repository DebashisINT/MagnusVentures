package com.breezefieldmagnus.features.nearbyuserlist.api

import com.breezefieldmagnus.app.Pref
import com.breezefieldmagnus.features.nearbyuserlist.model.NearbyUserResponseModel
import com.breezefieldmagnus.features.newcollection.model.NewCollectionListResponseModel
import com.breezefieldmagnus.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}