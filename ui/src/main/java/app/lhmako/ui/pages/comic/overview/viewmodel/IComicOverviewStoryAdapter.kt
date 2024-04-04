package app.lhmako.ui.pages.comic.overview.viewmodel

import app.lhmako.ui.dto.ComicDTO

interface IComicOverviewStoryAdapter {
    suspend fun loadComic(id: String): Result<ComicDTO>
}