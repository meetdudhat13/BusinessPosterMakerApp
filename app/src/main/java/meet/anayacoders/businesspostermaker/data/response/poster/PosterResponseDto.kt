package meet.anayacoders.businesspostermaker.data.response.poster

import meet.anayacoders.businesspostermaker.data.response.poster.PosterDataDto

data class PosterResponseDto(
    val data: PosterDataDto,
    val error: Any,
    val message: String,
    val status: String,
    val timestamp: String
)