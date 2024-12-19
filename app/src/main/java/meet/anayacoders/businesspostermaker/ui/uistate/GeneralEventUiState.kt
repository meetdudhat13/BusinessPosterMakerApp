package meet.anayacoders.businesspostermaker.ui.uistate

import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.domain.model.GeneralEventCategoryItem

data class GeneralEventUiState(
    val isLoading: Boolean = false,
    val events: List<GeneralEvent>? = null,
    val error: String? = null,
    val query: String = "",
    val selectedEvent: GeneralEvent? = null,
    val isEmpty: Boolean = false,
    val languageFilter: String = "",
    val categories: List<GeneralEventCategoryItem>? = null,
    val searchedEventList: List<GeneralEvent>? = null,
)