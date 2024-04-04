package app.lhmako.domain

import app.lhmako.domain.adapters.IComicDataAdapter
import app.lhmako.domain.adapters.IMessagesAdapter
import app.lhmako.domain.business.logic.IComicBusinessLogic
import app.lhmako.domain.business.logic.imp.ComicBusinessLogic
import app.lhmako.domain.stories.IComicOverviewStory
import app.lhmako.domain.stories.IComicsListStory
import app.lhmako.domain.stories.imp.ComicOverviewStory
import app.lhmako.domain.stories.imp.ComicsListStory
import app.lhmako.domain.use.cases.IComicEvaluationUseCase
import app.lhmako.domain.use.cases.ILoadComicsListUseCase
import app.lhmako.domain.use.cases.imp.ComicEvaluationUseCase
import app.lhmako.domain.use.cases.imp.LoadComicsListUseCase

/**
 * The injections files instantiate the classes, providing a practical context for their operation.
 * In a real-world scenario, these could be replaced with a dependency injection library like Dagger or Koin for more streamlined management.
 */
class DomainDependencies(
    messagesAdapter: IMessagesAdapter,
    comicDataAdapter: IComicDataAdapter
) {

    private val comicBusinessLogic: IComicBusinessLogic by lazy { ComicBusinessLogic(messagesAdapter) }
    private val comicsListUseCase: ILoadComicsListUseCase by lazy {
        LoadComicsListUseCase(
            comicBusinessLogic
        )
    }
    private val comicEvaluationUseCase: IComicEvaluationUseCase by lazy {
        ComicEvaluationUseCase(
            comicBusinessLogic
        )
    }

    val comicsListStory: IComicsListStory by lazy {
        ComicsListStory(
            comicDataAdapter = comicDataAdapter,
            comicsListUseCase = comicsListUseCase,
            comicEvaluationUseCase = comicEvaluationUseCase
        )
    }

    val comicOverviewStory: IComicOverviewStory by lazy {
        ComicOverviewStory(
            dataAdapter = comicDataAdapter,
            comicEvaluationUseCase = comicEvaluationUseCase
        )
    }
}