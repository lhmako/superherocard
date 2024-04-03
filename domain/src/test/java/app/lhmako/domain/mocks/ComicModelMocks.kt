package app.lhmako.domain.mocks

import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel

class ComicModelMocks {
    companion object {
        val comics = mutableListOf(
            ComicModel(
                id = ID(123456),
                title = "Test 1",
                ImageModel(
                    id = ID(123456),
                    path = "https://i.pravatar.cc/150?img=1",
                    extension = ImageExtensionType.JPEG
                ),
                description = "Test Description 1"
            ),
            ComicModel(
                id = ID(4321),
                title = "Test 2",
                ImageModel(
                    id = ID(98765),
                    path = "https://i.pravatar.cc/150?img=2",
                    extension = ImageExtensionType.JPEG
                ),
                description = "Test Description 2"
            ),
            ComicModel(
                id = ID(3242321),
                title = "Test 3",
                ImageModel(
                    id = ID(2312),
                    path = "https://i.pravatar.cc/150?img=3",
                    extension = ImageExtensionType.PNG
                ),
                description = "Test Description 3"
            ),
            ComicModel(
                id = ID(3242321),
                title = "Test 4",
                ImageModel(
                    id = ID(2312),
                    path = "https://i.pravatar.cc/150?img=4",
                    extension = ImageExtensionType.PNG
                ),
                description = "Test Description 4"
            )
        )
    }
}