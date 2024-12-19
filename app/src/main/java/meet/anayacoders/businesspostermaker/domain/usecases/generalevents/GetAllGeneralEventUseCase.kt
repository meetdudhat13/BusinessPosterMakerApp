package meet.anayacoders.businesspostermaker.domain.usecases.generalevents

import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.domain.repository.GeneralEventRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class GetAllGeneralEventUseCase @Inject constructor(
    private val repository: GeneralEventRepository
) {
    suspend operator fun invoke(): Resource<List<GeneralEvent>> = repository.getAllEvents()
}