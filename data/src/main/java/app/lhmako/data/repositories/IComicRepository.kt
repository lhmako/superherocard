package app.lhmako.data.repositories

import app.lhmako.data.dto.ComicDTO
import retrofit2.http.Query
import java.sql.Timestamp

interface IComicRepository {
    suspend fun getAll(): Result<List<ComicDTO>>
    suspend fun getBy(id: String): Result<ComicDTO>

    suspend fun searchBy(text: String): Result<List<ComicDTO>>
}