package app.lhmako.ui.adpaters

import app.lhmako.ui.pages.comic.list.viewmodel.IComicsStoryAdapter
import app.lhmako.ui.pages.comic.overview.viewmodel.IComicOverviewStoryAdapter

interface IAppResourcesAdapter {
    val comicsStoryAdapter: IComicsStoryAdapter
    val comicOverviewStoryAdapter: IComicOverviewStoryAdapter
}