package app.lhmako.domain.stories

import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID

interface IComicOverviewStory {
    suspend fun getComicBy(id: ID): Result<ComicModel>
}