package meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents

import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventsResponseDto
import meet.anayacoders.businesspostermaker.domain.model.UpcomingEvent
import meet.anayacoders.businesspostermaker.domain.repository.UpcomingEventRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class AddNewUpcomingEventUseCase @Inject constructor(
    private val repository: UpcomingEventRepository,
) {
    suspend operator fun invoke(event: UpcomingEvent) : Resource<UpcomingEventsResponseDto> = repository.addEvent(event)
}