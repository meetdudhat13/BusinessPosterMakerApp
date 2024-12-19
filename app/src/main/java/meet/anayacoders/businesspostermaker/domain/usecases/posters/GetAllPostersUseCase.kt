package meet.anayacoders.businesspostermaker.domain.usecases.posters

import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class GetAllPostersUseCase @Inject constructor(
    private val repository: PosterRepository
) {
    suspend operator fun invoke(): Resource<List<Poster>> = repository.getAllPosters()
}