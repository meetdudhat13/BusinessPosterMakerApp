package meet.anayacoders.businesspostermaker.data.response.generalEvent

import meet.anayacoders.businesspostermaker.data.response.generalEvent.GeneralEventsDataDto

data class GeneralEventsResponseDto(
    val data: GeneralEventsDataDto,
    val error: Any,
    val message: String,
    val status: String,
    val timestamp: String
)