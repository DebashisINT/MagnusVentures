package com.breezefieldmagnus.features.damageProduct.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.breezefieldmagnus.app.FileUtils
import com.breezefieldmagnus.base.BaseResponse
import com.breezefieldmagnus.features.NewQuotation.model.*
import com.breezefieldmagnus.features.addshop.model.AddShopRequestData
import com.breezefieldmagnus.features.addshop.model.AddShopResponse
import com.breezefieldmagnus.features.damageProduct.model.DamageProductResponseModel
import com.breezefieldmagnus.features.damageProduct.model.delBreakageReq
import com.breezefieldmagnus.features.damageProduct.model.viewAllBreakageReq
import com.breezefieldmagnus.features.login.model.userconfig.UserConfigResponseModel
import com.breezefieldmagnus.features.myjobs.model.WIPImageSubmit
import com.breezefieldmagnus.features.photoReg.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class GetDamageProductListRegRepository(val apiService : GetDamageProductListApi) {

    fun viewBreakage(req: viewAllBreakageReq): Observable<DamageProductResponseModel> {
        return apiService.viewBreakage(req)
    }

    fun delBreakage(req: delBreakageReq): Observable<BaseResponse>{
        return apiService.BreakageDel(req.user_id!!,req.breakage_number!!,req.session_token!!)
    }

}