package app.lhmako.domain.business.logic

import app.lhmako.domain.adapters.IMessagesAdapter
import app.lhmako.domain.business.logic.imp.ComicBusinessLogic
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.RuntimeException

class ComicBusinessLogicUnitTesting {

    private lateinit var messagesAdapter: IMessagesAdapter
    private lateinit var comicBusinessLogic: IComicBusinessLogic

    @Before
    fun setup() {
        messagesAdapter = Mockito.mock(IMessagesAdapter::class.java)
        comicBusinessLogic = ComicBusinessLogic(messagesAdapter)
    }

    @Test
    fun `test comic business image path validation`() {
        val model = ComicModel(
            id = ID(123456),
            title = "Testing",
            image = ImageModel(
                id = ID(123456),
                path = "fake://i.pravatar.cc/150?img=3",
                extension = ImageExtensionType.JPEG
            ),
            description = "Test description"
        )
        val result = comicBusinessLogic(model)
        result.onFailure { error ->
            assertEquals(error.message, messagesAdapter.imagePathMalformed(model.image.path))
        }
        result.onSuccess { throw RuntimeException("Comic model is empty.") }
    }

    @Test
    fun `test comic business comic is empty`() {
        val model = ComicModel(
            id = ID(""),
            title = "",
            image = ImageModel(
                id = ID(""),
                path = "",
                extension = ImageExtensionType.NAN
            ),
            description = ""
        )
        val result = comicBusinessLogic(model)
        result.onFailure { error ->
            assertEquals(error.message, messagesAdapter.comicNotFound)
        }
        result.onSuccess { throw RuntimeException("Path is not validated.") }
    }

    @Test
    fun `test comic business success evaluation`() {
        val model = ComicModel(
            id = ID(123456),
            title = "Testing",
            image = ImageModel(
                id = ID(123456),
                path = "https://i.pravatar.cc/150?img=3",
                extension = ImageExtensionType.JPEG
            ),
            description = "Test description"
        )
        val comic = comicBusinessLogic(model).getOrThrow()
        assertEquals(model, comic)
    }
}