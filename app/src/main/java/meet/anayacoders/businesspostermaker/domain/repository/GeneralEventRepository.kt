package meet.anayacoders.businesspostermaker.domain.repository

import meet.anayacoders.businesspostermaker.data.response.generalEvent.GeneralEventsResponseDto
import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.other.Resource

interface GeneralEventRepository {
    suspend fun getAllEvents(): Resource<List<GeneralEvent>>

    suspend fun addEvent(event: GeneralEvent): Resource<GeneralEventsResponseDto>

    suspend fun deleteEvent(event: GeneralEvent): Resource<GeneralEventsResponseDto>

    suspend fun updateEvent(event: GeneralEvent): Resource<GeneralEventsResponseDto>

    suspend fun searchGeneralEventByTitle(query: String): Resource<List<GeneralEvent>>

    suspend fun searchGeneralEventByCategory(query: String): Resource<List<GeneralEvent>>

    suspend fun searchGeneralEventByCombinedSearch(query: String): Resource<List<GeneralEvent>>
}