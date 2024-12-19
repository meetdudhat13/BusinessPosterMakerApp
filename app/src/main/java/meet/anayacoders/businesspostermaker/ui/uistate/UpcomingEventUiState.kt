package meet.anayacoders.businesspostermaker.ui.uistate

import meet.anayacoders.businesspostermaker.domain.model.UpcomingEvent
import meet.anayacoders.businesspostermaker.domain.model.UpcomingEventCategoryItem

data class UpcomingEventUiState(
    val isLoading: Boolean = false,
    val events: List<UpcomingEvent>? = null,
    val error: String? = null,
    val query: String = "",
    val selectedPoster: UpcomingEvent? = null,
    val isEmpty: Boolean = false,
    val languageFilter: String = "",
    val categories: List<UpcomingEventCategoryItem>? = null,
    val searchedEventList: List<UpcomingEvent>?=null
)