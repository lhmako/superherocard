package app.lhmako.superherocard

import android.content.Context
import app.lhmako.data.DataDependencies
import app.lhmako.domain.DomainDependencies
import app.lhmako.domain.adapters.IComicDataAdapter
import app.lhmako.superherocard.adapters.comic.ComicDataAdapter
import app.lhmako.superherocard.adapters.comic.ComicOverviewStoryAdapter
import app.lhmako.superherocard.adapters.comic.ComicsStoryAdapter
import app.lhmako.superherocard.adapters.messages.MessagesAdapter
import app.lhmako.ui.pages.comic.list.viewmodel.IComicsStoryAdapter
import app.lhmako.ui.pages.comic.overview.viewmodel.IComicOverviewStoryAdapter

/**
 * The injections files instantiate the classes, providing a practical context for their operation.
 * In a real-world scenario, these could be replaced with a dependency injection library like Dagger or Koin for more streamlined management.
 */

class AppDependencies(context: Context) {
    private val dataDependencies by lazy { DataDependencies(context) }
    private val comicDataAdapter: IComicDataAdapter by lazy {
        ComicDataAdapter(dataDependencies.comicRepository)
    }
    private val messagesAdapter by lazy { MessagesAdapter(context) }
    private val domainDependencies by lazy {
        DomainDependencies(messagesAdapter, comicDataAdapter)
    }
    val comicsDataAdapter: IComicsStoryAdapter
        get() = ComicsStoryAdapter(domainDependencies.comicsListStory)

    val comicsOverviewStoryAdapter: IComicOverviewStoryAdapter
        get() = ComicOverviewStoryAdapter(
            domainDependencies.comicOverviewStory
        )
}