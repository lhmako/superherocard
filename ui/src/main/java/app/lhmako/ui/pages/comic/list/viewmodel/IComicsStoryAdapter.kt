package app.lhmako.ui.pages.comic.list.viewmodel

import app.lhmako.ui.dto.ComicDTO

interface IComicsStoryAdapter {
    suspend fun loadComics(): Result<List<ComicDTO>>
}