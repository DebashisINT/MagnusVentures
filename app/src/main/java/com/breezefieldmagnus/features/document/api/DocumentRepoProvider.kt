package com.breezefieldmagnus.features.document.api

import com.breezefieldmagnus.features.dymanicSection.api.DynamicApi
import com.breezefieldmagnus.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}