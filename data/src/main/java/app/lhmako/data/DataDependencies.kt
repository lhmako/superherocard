package app.lhmako.data

import android.content.Context
import app.lhmako.data.repositories.IComicRepository
import app.lhmako.data.retrofit.configuration.ApiDataConfig
import app.lhmako.data.retrofit.configuration.Endpoint
import app.lhmako.data.retrofit.configuration.RetrofitBuilderAdapter
import app.lhmako.data.retrofit.rest.ComicRetrofitRepository

/**
 * The injections files instantiate the classes, providing a practical context for their operation.
 * In a real-world scenario, these could be replaced with a dependency injection library like Dagger or Koin for more streamlined management.
 */

class DataDependencies(context: Context) {

    private val retrofitPostmanMock by lazy {
        RetrofitBuilderAdapter(Endpoint.PostmanMocking).build()
    }

    private val retrofitMarvelApi by lazy {
        RetrofitBuilderAdapter(Endpoint.PostmanMocking).build()
    }

    private val apiDataConfig by lazy { ApiDataConfig(context) }

    val comicRepository: IComicRepository by lazy {
        ComicRetrofitRepository(retrofitPostmanMock, apiDataConfig)
    }
}