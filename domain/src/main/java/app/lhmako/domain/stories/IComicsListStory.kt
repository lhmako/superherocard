package app.lhmako.domain.stories

import app.lhmako.domain.models.ComicModel

interface IComicsListStory {
    suspend fun loadComics(): Result<List<ComicModel>>
    suspend fun searchComicBy(text: String): Result<ComicModel>
}