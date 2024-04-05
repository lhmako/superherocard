package app.lhmako.superherocard.adapters.comic

import app.lhmako.domain.models.ID
import app.lhmako.domain.stories.IComicOverviewStory
import app.lhmako.domain.stories.IComicsListStory
import app.lhmako.ui.dto.ComicDTO
import app.lhmako.ui.pages.comic.list.viewmodel.IComicsStoryAdapter
import app.lhmako.ui.pages.comic.overview.viewmodel.IComicOverviewStoryAdapter

class ComicOverviewStoryAdapter(
    private val comicsListStoryAdapter: IComicOverviewStory
) : IComicOverviewStoryAdapter {
    override suspend fun loadComic(id: String): Result<ComicDTO> {
        val comicModel = comicsListStoryAdapter.getComicBy(ID(id)).getOrElse {
            return Result.failure(it)
        }
        return Result.success(
            ComicDTO(
                id = comicModel.id.id,
                title = comicModel.title,
                description = comicModel.description,
                imageUrl = comicModel.image.path
            )
        )
    }
}