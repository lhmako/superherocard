package app.lhmako.domain.models

data class ImageModel(
    val id: ID,
    val path: String,
    val extension: ImageExtensionType
)