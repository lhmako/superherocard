package app.lhmako.superherocard.adapters.comic

import app.lhmako.domain.adapters.IComicDataAdapter
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID

class ComicDataAdapter : IComicDataAdapter {
    override suspend fun getComics(): Result<List<ComicModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getComicBy(id: ID): Result<ComicModel> {
        TODO("Not yet implemented")
    }

    override suspend fun searchComicBy(text: String): Result<ComicModel> {
        TODO("Not yet implemented")
    }
}