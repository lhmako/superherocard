package app.lhmako.domain.stories.imp

import app.lhmako.domain.adapters.IComicDataAdapter
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.stories.IComicOverviewStory
import app.lhmako.domain.use.cases.IComicEvaluationUseCase

class ComicOverviewStory(
    private val dataAdapter: IComicDataAdapter,
    private val comicEvaluationUseCase: IComicEvaluationUseCase
) : IComicOverviewStory {

    override suspend fun getComicBy(id: ID): Result<ComicModel> {
        val comic = dataAdapter.getComicBy(id).getOrElse { return Result.failure(it) }
        return comicEvaluationUseCase(comic)
    }


}