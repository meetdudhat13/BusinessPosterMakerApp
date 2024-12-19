package meet.anayacoders.businesspostermaker.data.response.upcomingevent

import meet.anayacoders.businesspostermaker.data.response.poster.Pagination
import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventDto

data class UpcomingEventsDataDto(
    val event: List<UpcomingEventDto>,
    val pagination: Pagination
)