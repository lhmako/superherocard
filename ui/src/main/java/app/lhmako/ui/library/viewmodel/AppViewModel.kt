package app.lhmako.ui.library.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class AppViewModel : ViewModel(), IAppViewModel {
    private val mError = MutableLiveData<Throwable>()
    override val error: LiveData<Throwable> get() = mError

    fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                mError.postValue(e)
            }
        }
    }
}