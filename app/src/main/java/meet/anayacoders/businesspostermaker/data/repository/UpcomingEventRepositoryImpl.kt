package meet.anayacoders.businesspostermaker.data.repository

import meet.anayacoders.businesspostermaker.data.database.remote.ApiService
import meet.anayacoders.businesspostermaker.data.mapper.toUpcomingEvent
import meet.anayacoders.businesspostermaker.data.mapper.toUpcomingEventDto
import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventsResponseDto
import meet.anayacoders.businesspostermaker.domain.model.UpcomingEvent
import meet.anayacoders.businesspostermaker.domain.repository.UpcomingEventRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class UpcomingEventRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UpcomingEventRepository {

    override suspend fun getAllEvents(): Resource<List<UpcomingEvent>> {
        val response = apiService.getAllUpComingEvent()
        return if (response.status == "success") {
            Resource.Success(response.data.event.map { it.toUpcomingEvent() } ?: emptyList())
        } else {
            Resource.Error("Something went wrong!", emptyList())
        }
    }

    override suspend fun addEvent(event: UpcomingEvent): Resource<UpcomingEventsResponseDto> {
        return try {
            val response = apiService.addUpcomingEvent(event.toUpcomingEventDto())
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun deleteEvent(event: UpcomingEvent): Resource<UpcomingEventsResponseDto> {
        return try {
            val response = apiService.deleteUpcomingEvent(event.id)
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun updateEvent(event: UpcomingEvent): Resource<UpcomingEventsResponseDto> {
        return try {
            val response =
                apiService.updateUpcomingEvent(
                    evenId = event.id,
                    event = event.toUpcomingEventDto()
                )
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchUpcomingEventByTitle(query: String): Resource<List<UpcomingEvent>> {
        return try {
            val response =
                apiService.searchUpcomingEventByTitle(query)
            if (response.status == "success")
                Resource.Success(response.data.event.map { it.toUpcomingEvent() })
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchUpcomingEventByCategory(query: String): Resource<List<UpcomingEvent>> {
        return try {
            val response =
                apiService.searchUpcomingEventByCategory(query)
            if (response.status == "success")
                Resource.Success(response.data.event.map { it.toUpcomingEvent() })
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchUpcomingEventByCombinedSearch(query: String): Resource<List<UpcomingEvent>> {
        return try {
            val response =
                apiService.searchUpcomingEventByCombinedSearch(query)
            if (response.status == "success")
                Resource.Success(response.data.event.map { it.toUpcomingEvent() })
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

}