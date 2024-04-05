package app.lhmako.domain.stories.imp

import app.lhmako.domain.adapters.IComicDataAdapter
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.stories.IComicsListStory
import app.lhmako.domain.use.cases.ILoadComicsListUseCase
import app.lhmako.domain.use.cases.IComicEvaluationUseCase

class ComicsListStory(
    private val comicDataAdapter: IComicDataAdapter,
    private val comicsListUseCase: ILoadComicsListUseCase,
    private val comicEvaluationUseCase: IComicEvaluationUseCase
) : IComicsListStory {
    override suspend fun loadComics(): Result<List<ComicModel>> {
        val comics = comicDataAdapter.getComics().getOrElse { return Result.failure(it) }
        return comicsListUseCase(comics)
    }

    override suspend fun searchComicBy(text: String): Result<ComicModel> {
        val comic = comicDataAdapter.searchComicBy(text).getOrElse { return Result.failure(it) }
        return comicEvaluationUseCase(comic)
    }
}