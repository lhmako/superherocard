package app.lhmako.superherocard.adapters

import app.lhmako.superherocard.AppDependencies
import app.lhmako.ui.adpaters.IAppResourcesAdapter
import app.lhmako.ui.pages.comic.list.viewmodel.IComicsStoryAdapter
import app.lhmako.ui.pages.comic.overview.viewmodel.IComicOverviewStoryAdapter

class AppResourcesAdapter(
    private val appDependencies: AppDependencies
) : IAppResourcesAdapter {
    override val comicsStoryAdapter: IComicsStoryAdapter
        get() = appDependencies.comicsDataAdapter
    override val comicOverviewStoryAdapter: IComicOverviewStoryAdapter
        get() = appDependencies.comicsOverviewStoryAdapter
}