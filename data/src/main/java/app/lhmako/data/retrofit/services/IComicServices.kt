package app.lhmako.data.retrofit.services

import app.lhmako.data.dto.ComicDTO
import app.lhmako.data.retrofit.dto.ResAdapterDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface IComicServices {
    @GET("comics")
    suspend fun getAll(
        @Query(value = "ts") timestamp: Int,
        @Query(value = "apikey") publicKey: String,
        @Query(value = "hash") hash: String
    ): ResAdapterDTO<ComicDTO>
}