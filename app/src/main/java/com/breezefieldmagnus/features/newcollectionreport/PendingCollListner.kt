package com.breezefieldmagnus.features.newcollectionreport

import com.breezefieldmagnus.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}