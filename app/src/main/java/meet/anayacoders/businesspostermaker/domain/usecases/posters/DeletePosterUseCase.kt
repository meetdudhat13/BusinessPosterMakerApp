package meet.anayacoders.businesspostermaker.domain.usecases.posters

import meet.anayacoders.businesspostermaker.data.response.poster.PosterResponseDto
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class DeletePosterUseCase @Inject constructor(
    private val repository: PosterRepository,
) {
    suspend operator fun invoke(poster: Poster) : Resource<PosterResponseDto> = repository.deletePoster(poster)
}