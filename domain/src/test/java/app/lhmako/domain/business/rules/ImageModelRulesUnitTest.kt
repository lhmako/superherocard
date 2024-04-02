package app.lhmako.domain.business.rules

import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ImageModelRulesUnitTest {

    @Test
    fun test_business_is_empty() {
        val modelList = arrayOf(
            ImageModel(
                id = ID(""),
                path = "creating a path",
                extension = ImageExtensionType.JPG
            ),
            ImageModel(
                id = ID("12345"),
                path = "",
                extension = ImageExtensionType.JPG
            ),
            ImageModel(
                id = ID("12345"),
                path = "creating a path",
                extension = ImageExtensionType.NAN
            )
        )
        modelList.forEach { model ->
            assertTrue(model.isEmpty())
        }
    }

    @Test
    fun test_business_is_not_empty() {
        val model = ImageModel(
            id = ID(12345),
            path = "creating a path",
            extension = ImageExtensionType.JPG
        )
        assertFalse(model.isEmpty())
    }


    @Test
    fun test_business_is_path_is_valid() {
        val model = ImageModel(
            id = ID(12345),
            path = "https://tzgvp7n8bz3v-u4239.pressidiumcdn.com/wp-content/uploads/2022/08/holafly-logo.svg",
            extension = ImageExtensionType.JPG
        )
        assertTrue(model.isPathValidated())
    }

    @Test
    fun test_business_is_path_is_not_validated() {
        val model = ImageModel(
            id = ID(12345),
            path = "creating a path",
            extension = ImageExtensionType.PNG
        )
        assertFalse(model.isPathValidated())
    }

}