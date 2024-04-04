package app.lhmako.superherocard.adapters

import app.lhmako.superherocard.AppDependencies
import app.lhmako.ui.adpaters.IAppResourcesAdapter
import app.lhmako.ui.pages.comic.list.viewmodel.IComicsStoryAdapter

class AppResourcesAdapter(
    private val appDependencies: AppDependencies
) : IAppResourcesAdapter {
    override val comicsDataAdapter: IComicsStoryAdapter
        get() = appDependencies.comicsDataAdapter
}