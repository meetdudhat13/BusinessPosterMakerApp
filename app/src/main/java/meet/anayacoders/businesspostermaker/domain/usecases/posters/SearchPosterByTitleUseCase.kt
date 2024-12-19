package meet.anayacoders.businesspostermaker.domain.usecases.posters

import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class SearchPosterByTitleUseCase @Inject constructor(
    private val repository: PosterRepository,
) {
    suspend operator fun invoke(poster: String) : Resource<List<Poster>> = repository.searchPosterByTitle(poster)
}