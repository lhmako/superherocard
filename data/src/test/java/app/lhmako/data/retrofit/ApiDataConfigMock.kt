package app.lhmako.data.retrofit

import app.lhmako.data.retrofit.configuration.IApiDataConfig
import app.lhmako.data.retrofit.dto.ApiCredentialDTO

class ApiDataConfigMock : IApiDataConfig {
    override fun getCredentials(): Result<ApiCredentialDTO> {
        return Result.success(
            ApiCredentialDTO(
                timestamp = 1000,
                publicKey = "xyz",
                privateKey = "abc1234"
            )
        )
    }
}