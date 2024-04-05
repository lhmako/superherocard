package app.lhmako.domain.adapters

import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID

interface IComicDataAdapter {
    suspend fun getComics(): Result<List<ComicModel>>
    suspend fun getComicBy(id: ID): Result<ComicModel>
    suspend fun searchComicBy(text: String): Result<ComicModel>
}