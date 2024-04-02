package app.lhmako.domain.use.cases.imp

import app.lhmako.domain.business.logic.IComicBusinessLogic
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.use.cases.IComicEvaluationUseCase

class ComicEvaluationUseCase(
    private val comicBusinessLogic: IComicBusinessLogic
) : IComicEvaluationUseCase {
    override fun invoke(comic: ComicModel): Result<ComicModel> {
        return comicBusinessLogic(comic)
    }
}