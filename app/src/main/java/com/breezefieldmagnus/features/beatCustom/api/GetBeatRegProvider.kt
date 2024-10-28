package com.breezefieldmagnus.features.beatCustom.api



object GetBeatRegProvider {

    fun provideSaveButton(): GetBeatListRegRepository {
        return GetBeatListRegRepository(GetBeatProductListApi.create())
    }


}