package meet.anayacoders.businesspostermaker.data.repository

import meet.anayacoders.businesspostermaker.data.database.remote.ApiService
import meet.anayacoders.businesspostermaker.data.mapper.toPoster
import meet.anayacoders.businesspostermaker.data.mapper.toPosterDto
import meet.anayacoders.businesspostermaker.data.response.poster.PosterResponseDto
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class PosterRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PosterRepository {
    override suspend fun getAllPosters(): Resource<List<Poster>> {
        return try {
            val response = apiService.getAllPosters()
            if (response.status == "success") {
                Resource.Success(response.data.posters.map { it.toPoster() })
            } else {
                Resource.Error("Something went wrong!", emptyList())
            }
        } catch (e: Exception) {
            println(e)
            Resource.Error(e.toString())
        }
    }

    override suspend fun addPoster(poster: Poster): Resource<PosterResponseDto> {
        return try {
            val response = apiService.addPoster(poster.toPosterDto())
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun deletePoster(poster: Poster): Resource<PosterResponseDto> {
        return try {
            val response = apiService.deletePoster(poster.id)
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun updatePoster(poster: Poster): Resource<PosterResponseDto> {
        return try {
            val response =
                apiService.updatePoster(posterId = poster.id, poster = poster.toPosterDto())
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchPosterByTitle(query: String): Resource<List<Poster>> {
        return try {
            val response = apiService.searchPosterByTitle(query)
            if (response.status == "success") {
                Resource.Success(response.data.posters.map { it.toPoster() })
            } else {
                Resource.Error("Something went wrong!")
            }
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchPosterByCategory(query: String): Resource<List<Poster>> {
        return try {
            val response = apiService.searchPosterByCategory(query)
            if (response.status == "success") {
                Resource.Success(response.data.posters.map { it.toPoster() })
            } else {
                Resource.Error("Something went wrong!")
            }
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchPosterByCombinedSearch(query: String): Resource<List<Poster>> {
        return try {
            val response = apiService.searchPosterByCombinedSearch(query)
            if (response.status == "success") {
                Resource.Success(response.data.posters.map { it.toPoster() })
            } else {
                Resource.Error("Something went wrong!")
            }
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }
}