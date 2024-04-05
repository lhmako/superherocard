package app.lhmako.domain.use.cases

import app.lhmako.domain.adapters.IMessagesAdapter
import app.lhmako.domain.business.logic.IComicBusinessLogic
import app.lhmako.domain.business.logic.imp.ComicBusinessLogic
import app.lhmako.domain.mocks.ComicModelMocks
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel
import app.lhmako.domain.use.cases.imp.LoadComicsListUseCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class LoadComicsListUseCaseUnitTesting {

    private lateinit var messagesAdapter: IMessagesAdapter
    private lateinit var comicBusinessLogic: IComicBusinessLogic
    private lateinit var loadComicsListUseCase: ILoadComicsListUseCase

    @Before
    fun setup() {
        messagesAdapter = mock()
        comicBusinessLogic = ComicBusinessLogic(messagesAdapter)
        loadComicsListUseCase = LoadComicsListUseCase(comicBusinessLogic)
    }

    @Test
    fun `test load comics list use case all comics evaluated`() {
        val mocks = ComicModelMocks.comics
        mocks[0] = ComicModel(
            id = ID(123456),
            title = "Test X",
            ImageModel(
                id = ID(123456),
                path = "https://i.pravatar.cc/150?img=12",
                extension = ImageExtensionType.JPEG
            ),
            description = "Test Description 1"
        )
        val nComics = loadComicsListUseCase(comics = mocks).getOrThrow()
        assertEquals(mocks.size, nComics.size)
    }

    @Test
    fun `test load comics list use case error image path`() {
        val mocks = ComicModelMocks.comics
        mocks[0] = ComicModel(
            id = ID(123456),
            title = "Test X",
            ImageModel(
                id = ID(123456),
                path = "malformed",
                extension = ImageExtensionType.JPEG
            ),
            description = "Test Description 1"
        )
        val nComics = loadComicsListUseCase(comics = mocks).getOrNull()
        assertEquals(mocks.size - 1, nComics?.size)
    }

    @Test
    fun `test load comics list use case error image isEmpty`() {
        val mocks = ComicModelMocks.comics
        mocks[0] = ComicModel(
            id = ID(123456),
            title = "Test X",
            ImageModel(
                id = ID(""),
                path = "",
                extension = ImageExtensionType.NAN
            ),
            description = "Test Description 1"
        )
        val nComics = loadComicsListUseCase(comics = mocks).getOrNull()
        assertEquals(mocks.size - 1, nComics?.size)
    }

    @Test
    fun `test load comics list use case error isEmpty`() {
        val mocks = ComicModelMocks.comics
        mocks[0] = ComicModel(
            id = ID(""),
            title = "Test X",
            ImageModel(
                id = ID(""),
                path = "",
                extension = ImageExtensionType.NAN
            ),
            description = "Test Description 1"
        )
        val nComics = loadComicsListUseCase(comics = mocks).getOrNull()
        assertEquals(mocks.size - 1, nComics?.size)
    }

    @Test
    fun `test load comics list use case empty list`() {
        val mocks = arrayListOf(
            ComicModel(
                id = ID(""),
                title = "Test X",
                ImageModel(
                    id = ID(""),
                    path = "",
                    extension = ImageExtensionType.NAN
                ),
                description = "Test Description 1"
            )
        )
        val nComics = loadComicsListUseCase(comics = mocks).getOrNull()
        assertEquals(0, nComics?.size)
    }
}