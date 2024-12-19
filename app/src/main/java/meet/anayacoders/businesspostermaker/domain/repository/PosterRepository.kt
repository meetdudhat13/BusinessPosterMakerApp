package meet.anayacoders.businesspostermaker.domain.repository

import meet.anayacoders.businesspostermaker.data.response.poster.PosterResponseDto
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.other.Resource

interface PosterRepository {
    suspend fun getAllPosters(): Resource<List<Poster>>

    suspend fun addPoster(poster: Poster): Resource<PosterResponseDto>

    suspend fun deletePoster(poster: Poster): Resource<PosterResponseDto>

    suspend fun updatePoster(poster: Poster): Resource<PosterResponseDto>

    suspend fun searchPosterByTitle(query: String): Resource<List<Poster>>

    suspend fun searchPosterByCategory(query: String): Resource<List<Poster>>

    suspend fun searchPosterByCombinedSearch(query: String): Resource<List<Poster>>
}