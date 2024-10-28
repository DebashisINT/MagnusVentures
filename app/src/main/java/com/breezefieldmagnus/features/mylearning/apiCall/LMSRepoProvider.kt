package com.breezefieldmagnus.features.mylearning.apiCall

import com.breezefieldmagnus.features.login.api.opportunity.OpportunityListApi
import com.breezefieldmagnus.features.login.api.opportunity.OpportunityListRepo

object LMSRepoProvider {
    fun getTopicList(): LMSRepo {
        return LMSRepo(LMSApi.create())
    }
}