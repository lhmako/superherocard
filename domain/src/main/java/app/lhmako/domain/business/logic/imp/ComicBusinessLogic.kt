package app.lhmako.domain.business.logic.imp

import app.lhmako.domain.adapters.IMessagesAdapter
import app.lhmako.domain.business.logic.IComicBusinessLogic
import app.lhmako.domain.business.rules.isEmpty
import app.lhmako.domain.business.rules.isPathValidated
import app.lhmako.domain.models.ComicModel

class ComicBusinessLogic(
    private val messages: IMessagesAdapter
) : IComicBusinessLogic {
    override operator fun invoke(comic: ComicModel): Result<ComicModel> {
        return if (comic.isEmpty())
            Result.failure(Throwable(messages.comicNotFound))
        else if (!comic.image.isPathValidated()) {
            Result.failure(Throwable(messages.imagePathMalformed(comic.image.path)))
        } else
            Result.success(comic)
    }

}