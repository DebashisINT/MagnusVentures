package com.breezefieldmagnus.features.lead.api

import com.breezefieldmagnus.features.NewQuotation.api.GetQuotListRegRepository
import com.breezefieldmagnus.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}