package com.breezefieldmagnus.features.activities.api

import com.breezefieldmagnus.features.member.api.TeamApi
import com.breezefieldmagnus.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}