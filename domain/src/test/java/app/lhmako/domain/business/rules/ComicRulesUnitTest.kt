package app.lhmako.domain.business.rules

import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel
import org.junit.Test
import org.junit.Assert.*

class ComicRulesUnitTest {

    @Test
    fun `test comic id isEmpty`() {
        val model = ComicModel(
            id = ID(""),
            title = "Testing",
            image = ImageModel(
                id = ID(123456),
                path = "path",
                extension = ImageExtensionType.JPEG
            ),
            description = "Test description"
        )
        assertTrue(model.isEmpty())
    }

    @Test
    fun `test comic title isEmpty`() {
        val model = ComicModel(
            id = ID(123456),
            title = "",
            image = ImageModel(
                id = ID(123456),
                path = "path",
                extension = ImageExtensionType.JPEG
            ),
            description = "Test description"
        )
        assertTrue(model.isEmpty())
    }

    @Test
    fun `test comic image isEmpty`() {
        val model = ComicModel(
            id = ID(123456),
            title = "Testing",
            image = ImageModel(
                id = ID(""),
                path = "",
                extension = ImageExtensionType.NAN
            ),
            description = "Test description"
        )
        assertTrue(model.isEmpty())
    }
}