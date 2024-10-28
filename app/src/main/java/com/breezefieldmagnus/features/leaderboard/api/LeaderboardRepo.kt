package com.breezefieldmagnus.features.leaderboard.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.breezefieldmagnus.app.FileUtils
import com.breezefieldmagnus.app.Pref
import com.breezefieldmagnus.base.BaseResponse
import com.breezefieldmagnus.features.addshop.model.AddLogReqData
import com.breezefieldmagnus.features.addshop.model.AddShopRequestData
import com.breezefieldmagnus.features.addshop.model.AddShopResponse
import com.breezefieldmagnus.features.addshop.model.LogFileResponse
import com.breezefieldmagnus.features.addshop.model.UpdateAddrReq
import com.breezefieldmagnus.features.contacts.CallHisDtls
import com.breezefieldmagnus.features.contacts.CompanyReqData
import com.breezefieldmagnus.features.contacts.ContactMasterRes
import com.breezefieldmagnus.features.contacts.SourceMasterRes
import com.breezefieldmagnus.features.contacts.StageMasterRes
import com.breezefieldmagnus.features.contacts.StatusMasterRes
import com.breezefieldmagnus.features.contacts.TypeMasterRes
import com.breezefieldmagnus.features.dashboard.presentation.DashboardActivity
import com.breezefieldmagnus.features.login.model.WhatsappApiData
import com.breezefieldmagnus.features.login.model.WhatsappApiFetchData
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Created by Puja on 10-10-2024.
 */
class LeaderboardRepo(val apiService: LeaderboardApi) {

    fun branchlist(session_token: String): Observable<LeaderboardBranchData> {
        return apiService.branchList(session_token)
    }
    fun ownDatalist(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOwnData> {
        return apiService.ownDatalist(user_id,activitybased,branchwise,flag)
    }
    fun overAllAPI(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOverAllData> {
        return apiService.overAllDatalist(user_id,activitybased,branchwise,flag)
    }
}