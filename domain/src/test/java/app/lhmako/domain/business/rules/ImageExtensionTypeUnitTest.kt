package app.lhmako.domain.business.rules

import app.lhmako.domain.models.ImageExtensionType
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ImageExtensionTypeUnitTest {

    @Test
    fun `test image extension alias jpg`() {
        val imageExtension = ImageExtensionType alias "jpg"
        assertEquals(imageExtension, ImageExtensionType.JPG)
    }

    @Test
    fun `test image extension alias jpeg`() {
        val imageExtension = ImageExtensionType alias "jpeg"
        assertEquals(imageExtension, ImageExtensionType.JPEG)
    }

    @Test
    fun `test image extension alias png`() {
        val imageExtension = ImageExtensionType alias "png"
        assertEquals(imageExtension, ImageExtensionType.PNG)
    }

    @Test
    fun `test image extension alias not exists`() {
        val imageExtension = ImageExtensionType alias "no exists"
        assertEquals(imageExtension, ImageExtensionType.NAN)
    }

    @Test
    fun `test image extension isEmpty`() {
        val imageExtension = ImageExtensionType.NAN
        assertTrue(imageExtension.isEmpty())
    }
}