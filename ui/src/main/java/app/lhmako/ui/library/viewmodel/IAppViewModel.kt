package app.lhmako.ui.library.viewmodel

import androidx.lifecycle.LiveData

interface IAppViewModel {
    val error: LiveData<Throwable>
}