package meet.anayacoders.businesspostermaker.domain.repository

import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventsResponseDto
import meet.anayacoders.businesspostermaker.domain.model.UpcomingEvent
import meet.anayacoders.businesspostermaker.other.Resource

interface UpcomingEventRepository {
    suspend fun getAllEvents(): Resource<List<UpcomingEvent>>

    suspend fun addEvent(event: UpcomingEvent): Resource<UpcomingEventsResponseDto>

    suspend fun deleteEvent(event: UpcomingEvent): Resource<UpcomingEventsResponseDto>

    suspend fun updateEvent(event: UpcomingEvent): Resource<UpcomingEventsResponseDto>

    suspend fun searchUpcomingEventByTitle(query: String): Resource<List<UpcomingEvent>>

    suspend fun searchUpcomingEventByCategory(query: String): Resource<List<UpcomingEvent>>

    suspend fun searchUpcomingEventByCombinedSearch(query: String): Resource<List<UpcomingEvent>>
}