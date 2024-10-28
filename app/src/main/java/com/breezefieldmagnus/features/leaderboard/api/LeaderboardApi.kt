package com.breezefieldmagnus.features.leaderboard.api

import com.breezefieldmagnus.app.NetworkConstant
import com.breezefieldmagnus.base.BaseResponse
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
import com.breezefieldmagnus.features.login.model.WhatsappApiData
import com.breezefieldmagnus.features.login.model.WhatsappApiFetchData
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by Puja on 12-40-2014.
 */
interface LeaderboardApi {

    @FormUrlEncoded
    @POST("LeaderboardInfo/LeaderboardBranchLists")
    fun branchList(@Field("session_token") session_token: String): Observable<LeaderboardBranchData>

    @FormUrlEncoded
    @POST("LeaderboardInfo/LeaderboardOwnList")
    fun ownDatalist(@Field("user_id") user_id: String,@Field("activitybased") activitybased: String,@Field("branchwise") branchwise: String,@Field("flag") flag: String): Observable<LeaderboardOwnData>

    @FormUrlEncoded
    @POST("LeaderboardInfo/LeaderboardOverallList")
    fun overAllDatalist(@Field("user_id") user_id: String,@Field("activitybased") activitybased: String,@Field("branchwise") branchwise: String,@Field("flag") flag: String): Observable<LeaderboardOverAllData>


    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): LeaderboardApi {
            val retrofit = Retrofit.Builder()
                    .client(NetworkConstant.setTimeOut())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(NetworkConstant.ADD_SHOP_BASE_URL)
                    .build()

            return retrofit.create(LeaderboardApi::class.java)
        }

        fun createWithoutMultipart(): LeaderboardApi {
            val retrofit = Retrofit.Builder()
                    .client(NetworkConstant.setTimeOut())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(NetworkConstant.BASE_URL)
                    .build()

            return retrofit.create(LeaderboardApi::class.java)
        }
    }
}