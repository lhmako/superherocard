package app.lhmako.domain.use.cases.imp

import app.lhmako.domain.adapters.IComicDataAdapter
import app.lhmako.domain.business.logic.imp.ComicBusinessLogic
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.use.cases.IGetComicByIdUseCase

class GetComicByIdUseCase(
    private val comicDataAdapter: IComicDataAdapter,
    private val comicBusinessLogic: ComicBusinessLogic
) : IGetComicByIdUseCase {
    override suspend fun invoke(id: ID): Result<ComicModel> {
        val comic = comicDataAdapter.getComicBy(id).getOrElse { return Result.failure(it) }
        return comicBusinessLogic(comic)
    }
}