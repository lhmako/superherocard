package app.lhmako.data.repositories

import app.lhmako.data.dto.ComicDTO
import retrofit2.http.Query
import java.sql.Timestamp

interface IComicRepository {
    suspend fun getAll(): Result<List<ComicDTO>>
}