package app.lhmako.domain.use.cases

import app.lhmako.domain.models.ComicModel

interface IComicEvaluationUseCase {
    operator fun invoke(comic: ComicModel): Result<ComicModel>
}