package app.lhmako.domain.business.logic

import app.lhmako.domain.models.ComicModel

interface IComicBusinessLogic {
    operator fun invoke(comic: ComicModel): Result<ComicModel>
}