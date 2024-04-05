package app.lhmako.domain.use.cases

import app.lhmako.domain.models.ComicModel

interface ILoadComicsListUseCase {
    operator fun invoke(comics: List<ComicModel>): Result<List<ComicModel>>
}