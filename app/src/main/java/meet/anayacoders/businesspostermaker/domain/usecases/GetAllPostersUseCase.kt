package meet.anayacoders.businesspostermaker.domain.usecases

import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import javax.inject.Inject

class GetAllPostersUseCase @Inject constructor(
    private val repository: PosterRepository
) {
    suspend operator fun invoke(): List<Poster> = repository.getAllPosters()
}