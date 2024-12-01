package meet.anayacoders.businesspostermaker.data.repository

import meet.anayacoders.businesspostermaker.data.database.remote.PosterApiService
import meet.anayacoders.businesspostermaker.data.mapper.toPoster
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import javax.inject.Inject

class PosterRepositoryImpl @Inject constructor(
    private val apiService: PosterApiService
) : PosterRepository {
    override suspend fun getAllPosters(): List<Poster> {
        val response = apiService.getAllPosters()
        return if (response.status == "success") {
            response.data.posters.map { it.toPoster() }
        } else {
            emptyList()
        }
    }
}