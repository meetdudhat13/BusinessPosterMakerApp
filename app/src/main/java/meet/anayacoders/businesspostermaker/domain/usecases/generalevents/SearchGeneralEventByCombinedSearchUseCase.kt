package meet.anayacoders.businesspostermaker.domain.usecases.generalevents

import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.domain.repository.GeneralEventRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class SearchGeneralEventByCombinedSearchUseCase @Inject constructor(
    private val repository: GeneralEventRepository,
) {
    suspend operator fun invoke(poster: String) : Resource<List<GeneralEvent>> = repository.searchGeneralEventByCombinedSearch(poster)
}