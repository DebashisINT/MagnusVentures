package com.breezefieldmagnus.features.survey.api

import com.breezefieldmagnus.features.photoReg.api.GetUserListPhotoRegApi
import com.breezefieldmagnus.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}