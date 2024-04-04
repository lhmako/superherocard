package app.lhmako.data.retrofit.dto

import com.google.gson.annotations.SerializedName

data class ResultsDTO<T>(
    @SerializedName("results") val results: List<T>
)
data class ResAdapterDTO<T>(
    val data: ResultsDTO<T>
)
