package com.breezefieldmagnus.features.photoReg.present

import com.breezefieldmagnus.app.domain.ProspectEntity
import com.breezefieldmagnus.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}