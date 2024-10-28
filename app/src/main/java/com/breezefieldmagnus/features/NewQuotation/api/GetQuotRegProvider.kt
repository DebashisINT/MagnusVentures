package com.breezefieldmagnus.features.NewQuotation.api



object GetQuotRegProvider {

    fun provideSaveButton(): GetQuotListRegRepository {
        return GetQuotListRegRepository(GetQutoListApi.create())
    }


}