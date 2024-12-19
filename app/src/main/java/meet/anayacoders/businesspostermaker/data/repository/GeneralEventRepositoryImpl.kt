package meet.anayacoders.businesspostermaker.data.repository

import meet.anayacoders.businesspostermaker.data.database.remote.ApiService
import meet.anayacoders.businesspostermaker.data.mapper.toGeneralEvent
import meet.anayacoders.businesspostermaker.data.mapper.toGeneralEventDto
import meet.anayacoders.businesspostermaker.data.response.generalEvent.GeneralEventsResponseDto
import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.domain.repository.GeneralEventRepository
import meet.anayacoders.businesspostermaker.other.Resource
import javax.inject.Inject

class GeneralEventRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GeneralEventRepository {

    override suspend fun getAllEvents(): Resource<List<GeneralEvent>> {
        val response = apiService.getAllGeneralEvent()
        return if (response.status == "success") {
            Resource.Success(response.data.event.map { it.toGeneralEvent() } ?: emptyList())
        } else {
            Resource.Error("Something went wrong!", emptyList())
        }
    }

    override suspend fun addEvent(event: GeneralEvent): Resource<GeneralEventsResponseDto> {
        return try {
            val response = apiService.addGeneralEvent(event.toGeneralEventDto())
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun deleteEvent(event: GeneralEvent): Resource<GeneralEventsResponseDto> {
        return try {
            val response = apiService.deleteGeneralEvent(event.id)
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun updateEvent(event: GeneralEvent): Resource<GeneralEventsResponseDto> {
        return try {
            val response =
                apiService.updateGeneralEvent(evenId = event.id, event = event.toGeneralEventDto())
            if (response.status == "success")
                Resource.Success(response)
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchGeneralEventByTitle(query: String): Resource<List<GeneralEvent>> {
        return try {
            val response = apiService.searchGeneralEventByTitle(query)
            if (response.status == "success")
                Resource.Success(response.data.event.map { it.toGeneralEvent() })
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchGeneralEventByCategory(query: String): Resource<List<GeneralEvent>> {
        return try {
            val response = apiService.searchGeneralEventByCategory(query)
            if (response.status == "success")
                Resource.Success(response.data.event.map { it.toGeneralEvent() })
            else
                Resource.Error("Something went wrong!")
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }

    override suspend fun searchGeneralEventByCombinedSearch(query: String): Resource<List<GeneralEvent>> {
        return try {
            val response = apiService.searchGeneralEventByCombinedSearch(query)
            if (response.status == "success") {
                    Resource.Success(emptyList())
            } else {
                println(response.status)
                Resource.Error("Something went wrong!")
            }
        } catch (e: Exception) {
            Resource.Error(e.toString())
        }
    }
}