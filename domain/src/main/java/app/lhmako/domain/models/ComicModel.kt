package app.lhmako.domain.models

data class ComicModel(
    val id: ID,
    val title: String,
    val image: ImageModel,
    val description: String
)