package meet.anayacoders.businesspostermaker.data.response.upcomingevent

import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventsDataDto

data class UpcomingEventsResponseDto(
    val data: UpcomingEventsDataDto,
    val error: Any,
    val message: String,
    val status: String,
    val timestamp: String
)