package app.lhmako.domain.use.cases.imp

import app.lhmako.domain.business.logic.IComicBusinessLogic
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.use.cases.ILoadComicsListUseCase

class LoadComicsListUseCase(
    private val comicBusinessLogic: IComicBusinessLogic
) : ILoadComicsListUseCase {
    override operator fun invoke(comics: List<ComicModel>): Result<List<ComicModel>> {
        val nList = mutableListOf<ComicModel>()
        val listError = mutableListOf<String?>()
        comics.forEach { comic ->
            try {
                val nComic = comicBusinessLogic(comic).getOrThrow()
                nList.add(nComic)
            } catch (e: Throwable) {
                listError.add(e.message)
            }
        }
        return Result.success(nList)
        /*return if (listError.isEmpty())
            Result.success(nList)
        else
            Result.failure(
                Throwable(
                    listError.joinTo(StringBuilder(""), ", ").toString()
                )
            )*/
    }
}