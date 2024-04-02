package app.lhmako.domain.use.cases

import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID

interface IGetComicByIdUseCase {
    suspend operator fun invoke(id: ID): Result<ComicModel>
}