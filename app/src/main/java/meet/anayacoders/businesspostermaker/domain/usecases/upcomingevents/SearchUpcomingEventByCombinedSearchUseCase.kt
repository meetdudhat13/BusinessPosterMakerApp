package meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents

import meet.anayacoders.businesspostermaker.domain.model.UpcomingEvent
import meet.anayacoders.businesspostermaker.domain.repository.UpcomingEventRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class SearchUpcomingEventByCombinedSearchUseCase @Inject constructor(
    private val repository: UpcomingEventRepository,
) {
    suspend operator fun invoke(poster: String) : Resource<List<UpcomingEvent>> = repository.searchUpcomingEventByCombinedSearch(poster)
}