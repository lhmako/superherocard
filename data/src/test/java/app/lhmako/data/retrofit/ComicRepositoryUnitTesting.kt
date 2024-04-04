package app.lhmako.data.retrofit

import app.lhmako.data.repositories.IComicRepository
import app.lhmako.data.retrofit.configuration.Endpoint
import app.lhmako.data.retrofit.configuration.RetrofitBuilderAdapter
import app.lhmako.data.retrofit.rest.ComicRetrofitRepository
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class ComicRepositoryUnitTesting {

    @OptIn(DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    /**
     * The following test creates a request to get the data from a Postman mock service.
     * It could be fail if the requests quote is exceeded the
     */
    @Test
    fun `test get all comics from postman`(): Unit = runBlocking {
        launch(Dispatchers.Main) {
            val retrofitPostmanMock = RetrofitBuilderAdapter(Endpoint.PostmanMocking).build()
            val comicRepository: IComicRepository = ComicRetrofitRepository(retrofitPostmanMock)
            val comics = comicRepository.getAll(
                timestamp = 1000,
                publicKey = "xyz",
                hash = "abc1234"
            ).getOrThrow()
            assertEquals(10, comics.size)
        }
    }
}