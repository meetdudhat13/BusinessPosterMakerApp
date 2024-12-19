package meet.anayacoders.businesspostermaker.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.domain.model.GeneralEventCategoryItem
import meet.anayacoders.businesspostermaker.domain.usecases.generalevents.AddNewGeneralEventUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.generalevents.DeleteGeneralEventUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.generalevents.GetAllGeneralEventUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.generalevents.SearchGeneralEventByCategoryUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.generalevents.SearchGeneralEventByCombinedSearchUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.generalevents.SearchGeneralEventByTitleUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.generalevents.UpdateGeneralEventUseCase
import meet.anayacoders.businesspostermaker.ui.uistate.AddGeneralEventUiState
import meet.anayacoders.businesspostermaker.ui.uistate.GeneralEventUiState
import javax.inject.Inject

@HiltViewModel
class GeneralEventViewModel @Inject constructor(
    private val getAllGeneralEventUseCase: GetAllGeneralEventUseCase,
    private val addNewGeneralEventUseCase: AddNewGeneralEventUseCase,
    private val updateGeneralEventUseCase: UpdateGeneralEventUseCase,
    private val deleteGeneralEventUseCase: DeleteGeneralEventUseCase,
    private val searchGeneralEventByTitleUseCase: SearchGeneralEventByTitleUseCase,
    private val searchGeneralEventByCategoryUseCase: SearchGeneralEventByCategoryUseCase,
    private val searchGeneralEventByCombinedSearchUseCase: SearchGeneralEventByCombinedSearchUseCase
) : ViewModel() {

    var generalEventUiState by mutableStateOf(GeneralEventUiState())
        private set

    var addEventUiState by mutableStateOf(AddGeneralEventUiState())
        private set

    var selectedGeneralEvent by mutableStateOf<GeneralEvent?>(null)
        private set

    init {
        getAllGeneralEvents()
    }


    fun selectedPoster(poster: GeneralEvent) {
//        println("from viewmodel $poster")
//        posterUiState = posterUiState.copy(selectedPoster = poster)
        selectedGeneralEvent = poster
    }

//    fun selectedCategory(posterCategoryItem: GeneralEventCategoryItem) {
////        println("from viewmodel $poster")
//        generalEventUiState = generalEventUiState.copy(selectedCategory = posterCategoryItem)
////        selectedPoster = poster
//    }


    fun getAllGeneralEvents() {
        viewModelScope.launch {
            generalEventUiState = generalEventUiState.copy(isLoading = true)
            val events = getAllGeneralEventUseCase()
            if (events.data == null) {
                generalEventUiState = generalEventUiState.copy(isLoading = false)
                generalEventUiState = generalEventUiState.copy(error = events.message)
                generalEventUiState =
                    generalEventUiState.copy(categories = null)
                generalEventUiState = generalEventUiState.copy(events = null)

            } else {
                generalEventUiState = generalEventUiState.copy(isLoading = false)
                generalEventUiState = generalEventUiState.copy(error = null)
                generalEventUiState =
                    generalEventUiState.copy(categories = events.data.groupBy { it.category }
                        .map { (category, posterList) ->
                            GeneralEventCategoryItem(catName = category, posters = posterList)
                        })
                generalEventUiState = generalEventUiState.copy(events = events.data)
            }
        }
    }

    fun addNewGeneralEvent(event: GeneralEvent) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = addNewGeneralEventUseCase(event)
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
            getAllGeneralEvents()
        }
    }

    fun deleteGeneralEvent(event: GeneralEvent) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = deleteGeneralEventUseCase(event)
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
            getAllGeneralEvents()
        }
    }

    fun updateGeneralEvent(event: GeneralEvent) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = updateGeneralEventUseCase(event)
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
            getAllGeneralEvents()
        }
    }

    fun searchEventByCategory(poster: String) {
        viewModelScope.launch {
            addEventUiState = addEventUiState.copy(isLoading = true)
            val resp = searchGeneralEventByCategoryUseCase(poster)
            if (resp.data != null) {
                addEventUiState = addEventUiState.copy(isLoading = false)
                generalEventUiState = generalEventUiState.copy(query = poster)

                generalEventUiState =
                    generalEventUiState.copy(searchedEventList = resp.data)
                addEventUiState = addEventUiState.copy(error = "")

            } else {
                addEventUiState = addEventUiState.copy(isLoading = false)
                addEventUiState =
                    addEventUiState.copy(error = resp.message ?: "Error")
                generalEventUiState = generalEventUiState.copy(query = "")


                generalEventUiState =
                    generalEventUiState.copy(searchedEventList = null)
            }
        }
    }
}