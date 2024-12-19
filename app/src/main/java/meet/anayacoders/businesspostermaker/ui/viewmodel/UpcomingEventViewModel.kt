package meet.anayacoders.businesspostermaker.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import meet.anayacoders.businesspostermaker.domain.model.UpcomingEvent
import meet.anayacoders.businesspostermaker.domain.model.UpcomingEventCategoryItem
import meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents.AddNewUpcomingEventUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents.DeleteUpcomingEventUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents.GetAllUpcomingEventUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents.SearchUpcomingEventByCategoryUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents.SearchUpcomingEventByCombinedSearchUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents.SearchUpcomingEventByTitleUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.upcomingevents.UpdateUpcomingEventUseCase
import meet.anayacoders.businesspostermaker.ui.uistate.AddUpcomingEventUiState
import meet.anayacoders.businesspostermaker.ui.uistate.UpcomingEventUiState
import javax.inject.Inject

@HiltViewModel
class UpcomingEventViewModel @Inject constructor(
    private val getAllUpcomingEventUseCase: GetAllUpcomingEventUseCase,
    private val addNewUpcomingEventUseCase: AddNewUpcomingEventUseCase,
    private val updateUpcomingEventUseCase: UpdateUpcomingEventUseCase,
    private val deleteUpcomingEventUseCase: DeleteUpcomingEventUseCase,
    private val searchUpcomingEventByTitleUseCase: SearchUpcomingEventByTitleUseCase,
    private val searchUpcomingEventByCategoryUseCase: SearchUpcomingEventByCategoryUseCase,
    private val searchUpcomingEventByCombinedSearchUseCase: SearchUpcomingEventByCombinedSearchUseCase
) : ViewModel() {

    var upcomingEventUiState by mutableStateOf(UpcomingEventUiState())
        private set

    var addEventUiState by mutableStateOf(AddUpcomingEventUiState())
        private set

    var selectedUpcomingEvent by mutableStateOf<UpcomingEvent?>(null)
        private set

    init {
        getAllUpcomingEvent()
    }


    fun selectedPoster(poster: UpcomingEvent) {
//        println("from viewmodel $poster")
//        posterUiState = posterUiState.copy(selectedPoster = poster)
        selectedUpcomingEvent = poster
    }


    fun getAllUpcomingEvent() {
        viewModelScope.launch {
            upcomingEventUiState = upcomingEventUiState.copy(isLoading = true)
            val events = getAllUpcomingEventUseCase()
            if (events.data == null) {
                upcomingEventUiState = upcomingEventUiState.copy(isLoading = false)
                upcomingEventUiState = upcomingEventUiState.copy(error = events.message)
                upcomingEventUiState = upcomingEventUiState.copy(categories = null)
                upcomingEventUiState = upcomingEventUiState.copy(events = null)
            } else {
                upcomingEventUiState = upcomingEventUiState.copy(isLoading = false)
                upcomingEventUiState = upcomingEventUiState.copy(events = events.data)
                upcomingEventUiState =
                    upcomingEventUiState.copy(categories = events.data.groupBy { it.category }
                        .map { (category, posterList) ->
                            UpcomingEventCategoryItem(catName = category, posters = posterList)
                        })
                upcomingEventUiState = upcomingEventUiState.copy(error = null)
            }
        }
    }

    fun addNewUpcomingEvent(event: UpcomingEvent) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = addNewUpcomingEventUseCase(event)
            if (resp.data != null) {
                println(resp.data)
                addEventUiState = addEventUiState.copy(isLoading = false)
                addEventUiState = addEventUiState.copy(success = resp.data.status)
                addEventUiState = addEventUiState.copy(error = "")
            } else {
                println(resp.message)
                addEventUiState = addEventUiState.copy(isLoading = false)
                addEventUiState =
                    addEventUiState.copy(error = resp.message ?: "Error")
                addEventUiState = addEventUiState.copy(success = "")

            }
            getAllUpcomingEvent()
        }
    }

    fun deleteUpcomingEvent(event: UpcomingEvent) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = deleteUpcomingEventUseCase(event)
            if (resp.data != null) {
                addEventUiState = addEventUiState.copy(isLoading = false)
                addEventUiState = addEventUiState.copy(success = resp.data.status)
                addEventUiState = addEventUiState.copy(error = "")

            } else {
                addEventUiState = addEventUiState.copy(isLoading = false)
                addEventUiState =
                    addEventUiState.copy(error = resp.message ?: "Error")
                addEventUiState = addEventUiState.copy(success = "")

            }
            getAllUpcomingEvent()
        }
    }

    fun updateUpcomingEvent(event: UpcomingEvent) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = updateUpcomingEventUseCase(event)
            if (resp.data != null) {
                addEventUiState = addEventUiState.copy(isLoading = false)
                addEventUiState = addEventUiState.copy(success = resp.data.status)
                addEventUiState = addEventUiState.copy(error = "")

            } else {
                addEventUiState = addEventUiState.copy(isLoading = false)
                addEventUiState =
                    addEventUiState.copy(error = resp.message ?: "Error")
                addEventUiState = addEventUiState.copy(success = "")

            }
            getAllUpcomingEvent()
        }
    }
    fun searchEventByCategory(poster: String) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = searchUpcomingEventByCategoryUseCase(poster)
            if (resp.data != null) {
                addEventUiState = addEventUiState.copy(isLoading = false)
                upcomingEventUiState = upcomingEventUiState.copy(query = poster)

                upcomingEventUiState =
                    upcomingEventUiState.copy(searchedEventList = resp.data)
                addEventUiState = addEventUiState.copy(error = "")

            } else {
                addEventUiState = addEventUiState.copy(isLoading = false)
                upcomingEventUiState = upcomingEventUiState.copy(query = "")

                addEventUiState =
                    addEventUiState.copy(error = resp.message ?: "Error")
                upcomingEventUiState =
                    upcomingEventUiState.copy(searchedEventList = null)
            }
        }
    }

}