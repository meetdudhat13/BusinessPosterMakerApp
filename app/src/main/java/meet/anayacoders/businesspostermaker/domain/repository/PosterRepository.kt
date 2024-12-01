package meet.anayacoders.businesspostermaker.domain.repository

import meet.anayacoders.businesspostermaker.domain.model.Poster

interface PosterRepository {
    suspend fun getAllPosters(): List<Poster>
}