package app.lhmako.ui.library.viewmodel

import app.lhmako.ui.pages.comic.list.viewmodel.ComicsViewModel

interface IViewModelFactory {
    val comicsViewModel: ComicsViewModel
}