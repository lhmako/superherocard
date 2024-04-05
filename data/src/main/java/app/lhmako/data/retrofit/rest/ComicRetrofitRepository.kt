package app.lhmako.data.retrofit.rest

import app.lhmako.data.dto.ComicDTO
import app.lhmako.data.repositories.IComicRepository
import app.lhmako.data.retrofit.configuration.IApiDataConfig
import app.lhmako.data.retrofit.services.IComicServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import retrofit2.Retrofit

class ComicRetrofitRepository(
    private val api: Retrofit,
    private val apiDataConfig: IApiDataConfig
) : IComicRepository {

    private var comicsCache = mutableListOf<ComicDTO>()
    override suspend fun getAll(): Result<List<ComicDTO>> {
        if (comicsCache.isNotEmpty()) return Result.success(comicsCache)
        return runBlocking(Dispatchers.IO) {
            try {
                val credentials = apiDataConfig.getCredentials().getOrThrow()
                val comics = api.create(IComicServices::class.java).getAll(
                    credentials.timestamp,
                    credentials.publicKey,
                    credentials.hash()
                ).data.results
                comicsCache = comics.toMutableList()
                Result.success(comics)
            } catch (e: HttpException) {
                Result.failure(e)
            }
        }
    }

    override suspend fun getBy(id: String): Result<ComicDTO> {
        val comicDTO = getAll().getOrElse { return Result.failure(it) }.find { it.id == id }
        return if (comicDTO == null) {
            Result.failure(Throwable("Comic not found"))
        } else {
            Result.success(comicDTO)
        }
    }

    override suspend fun searchBy(text: String): Result<List<ComicDTO>> {
        val founds = mutableListOf<ComicDTO>()
        getAll().getOrElse { return Result.failure(it) }.forEach { comicDTO ->
            if (comicDTO.title?.startsWith(text) == true) {
                founds.add(comicDTO)
            }
        }
        return if (founds.isNotEmpty()) {
            Result.failure(Throwable("Comic not found"))
        } else {
            Result.success(founds)
        }
    }

}