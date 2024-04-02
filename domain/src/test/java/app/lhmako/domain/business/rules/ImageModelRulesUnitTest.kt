package app.lhmako.domain.business.rules

import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ImageModelRulesUnitTest {

    @Test
    fun `test image rule is id isEmpty`() {
        val model = ImageModel(
            id = ID(""),
            path = "creating a path",
            extension = ImageExtensionType.JPG
        )
        assertTrue(model.isEmpty())
    }

    @Test
    fun `test image rule is path isEmpty`() {
        val model = ImageModel(
            id = ID("123456"),
            path = "",
            extension = ImageExtensionType.JPG
        )
        assertTrue(model.isEmpty())
    }

    @Test
    fun `test image rule is extension isEmpty`() {
        val model = ImageModel(
            id = ID("123456"),
            path = "creating a path",
            extension = ImageExtensionType.NAN
        )
        assertTrue(model.isEmpty())
    }

    @Test
    fun `test image rule isEmpty`() {
        val model = ImageModel(
            id = ID(""),
            path = "",
            extension = ImageExtensionType.NAN
        )
        assertTrue(model.isEmpty())
    }

    @Test
    fun `test image rule not isEmpty`() {
        val model = ImageModel(
            id = ID(12345),
            path = "creating a path",
            extension = ImageExtensionType.JPG
        )
        assertFalse(model.isEmpty())
    }

    @Test
    fun `test image rule is path isPathValidated`() {
        val model = ImageModel(
            id = ID(12345),
            path = "https://tzgvp7n8bz3v-u4239.pressidiumcdn.com/wp-content/uploads/2022/08/holafly-logo.svg",
            extension = ImageExtensionType.JPG
        )
        assertTrue(model.isPathValidated())
    }

    @Test
    fun `test image rule is path not isPathValidated`() {
        val model = ImageModel(
            id = ID(12345),
            path = "creating a path",
            extension = ImageExtensionType.PNG
        )
        assertFalse(model.isPathValidated())
    }

}