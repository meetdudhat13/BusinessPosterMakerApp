package meet.anayacoders.businesspostermaker.domain.usecases.generalevents

import meet.anayacoders.businesspostermaker.data.response.generalEvent.GeneralEventsResponseDto
import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.domain.repository.GeneralEventRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class AddNewGeneralEventUseCase @Inject constructor(
    private val repository: GeneralEventRepository,
) {
    suspend operator fun invoke(event: GeneralEvent) : Resource<GeneralEventsResponseDto> = repository.addEvent(event)
}