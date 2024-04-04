package app.lhmako.data.retrofit.configuration

import app.lhmako.data.retrofit.dto.ApiCredentialDTO

interface IApiDataConfig {
    fun getCredentials(): Result<ApiCredentialDTO>
}