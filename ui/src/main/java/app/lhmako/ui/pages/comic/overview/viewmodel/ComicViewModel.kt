package app.lhmako.ui.pages.comic.overview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.lhmako.ui.dto.ComicDTO
import app.lhmako.ui.library.viewmodel.AppViewModel

class ComicViewModel(
    private val comicsViewModelAdapter: IComicOverviewStoryAdapter
) : AppViewModel() {

    private val mComic = MutableLiveData<ComicDTO>()
    val comic: LiveData<ComicDTO>
        get() {
            return mComic
        }

    fun loadComic(id:String) {
        launch {
            val result = comicsViewModelAdapter.loadComic(id).getOrThrow()
            mComic.postValue(result)
        }
    }
}