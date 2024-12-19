package meet.anayacoders.businesspostermaker.data.response.generalEvent

import meet.anayacoders.businesspostermaker.data.response.poster.Pagination

data class GeneralEventsDataDto(
    val event: List<GeneralEventDto>,
    val pagination: Pagination
)