package app.lhmako.data.retrofit.rest

import app.lhmako.data.dto.ComicDTO
import app.lhmako.data.repositories.IComicRepository
import app.lhmako.data.retrofit.configuration.ApiDataConfig
import app.lhmako.data.retrofit.services.IComicServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import retrofit2.Retrofit

class ComicRetrofitRepository(
    private val api: Retrofit,
    private val apiDataConfig: ApiDataConfig
) : IComicRepository {

    override suspend fun getAll(): Result<List<ComicDTO>> {
        return runBlocking(Dispatchers.IO) {
            try {
                val credentials = apiDataConfig.getCredentials().getOrThrow()
                val comics = api.create(IComicServices::class.java).getAll(
                    credentials.timestamp,
                    credentials.publicKey,
                    credentials.hash()
                ).data.results
                Result.success(comics)
            } catch (e: HttpException) {
                Result.failure(e)
            }
        }
    }

}