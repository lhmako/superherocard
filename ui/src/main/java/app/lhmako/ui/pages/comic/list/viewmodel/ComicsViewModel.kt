package app.lhmako.ui.pages.comic.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.lhmako.ui.dto.ComicDTO
import app.lhmako.ui.library.viewmodel.AppViewModel

class ComicsViewModel(
    private val comicsViewModelAdapter: IComicsStoryAdapter
) : AppViewModel() {

    private val mComics = MutableLiveData<List<ComicDTO>>()
    val comics: LiveData<List<ComicDTO>>
        get() {
            if (mComics.value == null) loadComics()
            return mComics
        }

    private fun loadComics() {
        launch {
            val result = comicsViewModelAdapter.loadComics().getOrThrow()
            mComics.postValue(result)
        }
    }
}