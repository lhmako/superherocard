package app.lhmako.superherocard.adapters.comic

import app.lhmako.data.repositories.IComicRepository
import app.lhmako.domain.adapters.IComicDataAdapter
import app.lhmako.domain.models.ComicModel
import app.lhmako.domain.models.ID
import app.lhmako.domain.models.ImageExtensionType
import app.lhmako.domain.models.ImageModel

class ComicDataAdapter(
    private val comicRepository: IComicRepository
) : IComicDataAdapter {
    override suspend fun getComics(): Result<List<ComicModel>> {
        val list = arrayListOf<ComicModel>()
        val comicsDTO = comicRepository.getAll().getOrElse { return Result.failure(it) }
        comicsDTO.forEach { comicDTO ->
            list.add(
                ComicModel(
                    id = ID(comicDTO.id),
                    title = comicDTO.title ?: "",
                    image = ImageModel(
                        ID(comicDTO.id),
                        path = comicDTO.thumbnail.path ?: "",
                        extension = ImageExtensionType alias (comicDTO.thumbnail.extension ?: "")
                    ),
                    description = comicDTO.description ?: ""
                )
            )
        }
        return Result.success(list)
    }

    override suspend fun getComicBy(id: ID): Result<ComicModel> {
        val comicDTO = comicRepository.getBy(id.id).getOrElse { return Result.failure(it) }
        return Result.success(
            ComicModel(
                id = id,
                title = comicDTO.title ?: "",
                image = ImageModel(
                    ID(comicDTO.id),
                    path = comicDTO.thumbnail.path ?: "",
                    extension = ImageExtensionType alias (comicDTO.thumbnail.extension ?: "")
                ),
                description = comicDTO.description ?: ""
            )
        )
    }

    override suspend fun searchComicBy(text: String): Result<ComicModel> {
        throw Exception("Not implemented yet")
    }
}