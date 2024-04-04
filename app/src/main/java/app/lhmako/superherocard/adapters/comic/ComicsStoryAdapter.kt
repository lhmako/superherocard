package app.lhmako.superherocard.adapters.comic

import app.lhmako.domain.stories.IComicsListStory
import app.lhmako.ui.dto.ComicDTO
import app.lhmako.ui.pages.comic.list.viewmodel.IComicsStoryAdapter

class ComicsStoryAdapter(
    private val comicsListStoryAdapter: IComicsListStory
) : IComicsStoryAdapter {
    override suspend fun loadComics(): Result<List<ComicDTO>> {
        val comicsModel = comicsListStoryAdapter.loadComics().getOrElse {
            return Result.failure(it)
        }
        val list = mutableListOf<ComicDTO>()
        comicsModel.forEach { comicModel ->
            list.add(
                ComicDTO(
                    id = comicModel.id.id,
                    title = comicModel.title,
                    imageUrl = comicModel.image.path,
                    description = comicModel.description
                )
            )
        }
        return Result.success(list)
    }
}