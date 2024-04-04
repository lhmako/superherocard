package app.lhmako.data.retrofit.configuration

import android.content.Context
import app.lhmako.data.retrofit.dto.ApiCredentialDTO
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class ApiDataConfig(
    private val context: Context
): IApiDataConfig {
    override fun getCredentials(): Result<ApiCredentialDTO> {
        return try {
            val file = context.assets.open("env.json")
            val bufferedReader = BufferedReader(InputStreamReader(file))
            val stringBuilder = StringBuilder()
            bufferedReader.useLines { lines ->
                lines.forEach {
                    stringBuilder.append(it)
                }
            }
            val jsonText = stringBuilder.toString()
            val credentials = Gson().fromJson(jsonText, ApiCredentialDTO::class.java)
            Result.success(credentials!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}