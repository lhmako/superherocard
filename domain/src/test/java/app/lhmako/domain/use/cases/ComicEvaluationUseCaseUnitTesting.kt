package app.lhmako.domain.use.cases

import app.lhmako.domain.adapters.IMessagesAdapter
import app.lhmako.domain.business.logic.IComicBusinessLogic
import app.lhmako.domain.business.logic.imp.ComicBusinessLogic
import app.lhmako.domain.mocks.ComicModelMocks
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel
import app.lhmako.domain.use.cases.imp.ComicEvaluationUseCase
import app.lhmako.domain.use.cases.imp.LoadComicsListUseCase
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ComicEvaluationUseCaseUnitTesting {

    private lateinit var messagesAdapter: IMessagesAdapter
    private lateinit var comicBusinessLogic: IComicBusinessLogic
    private lateinit var comicEvaluationUseCase: IComicEvaluationUseCase

    @Before
    fun setup() {
        messagesAdapter = Mockito.mock()
        comicBusinessLogic = ComicBusinessLogic(messagesAdapter)
        comicEvaluationUseCase = ComicEvaluationUseCase(comicBusinessLogic)
    }

    @Test
    fun `test comic evaluation is correct evaluated`() {
        val comic = ComicModelMocks.comics[0]
        val nComic = comicEvaluationUseCase(comic = comic).getOrThrow()
        assertEquals(comic, nComic)
    }

    @Test
    fun `test comic evaluation is empty`() {
        val comic = ComicModel(
            id = ID(""),
            title = "",
            ImageModel(
                id = ID(""),
                path = "",
                extension = ImageExtensionType.NAN
            ),
            description = ""
        )
        comicEvaluationUseCase(comic = comic).onFailure { error ->
            assertEquals(messagesAdapter.comicNotFound, error.message)
        }
        comicEvaluationUseCase(comic = comic).onSuccess {
            throw Exception("Comic is not empty")
        }
    }

    @Test
    fun `test comic evaluation is image malformed path`() {
        val comic = ComicModel(
            id = ID(123456),
            title = "Test 1",
            ImageModel(
                id = ID(123456),
                path = "malformed",
                extension = ImageExtensionType.JPEG
            ),
            description = "Test Description 1"
        )
        comicEvaluationUseCase(comic = comic).onFailure { error ->
            assertEquals(messagesAdapter.comicNotFound, error.message)
        }
        comicEvaluationUseCase(comic = comic).onSuccess {
            throw Exception("Comic is not empty")
        }
    }
}