package meet.anayacoders.businesspostermaker.data.mapper

import meet.anayacoders.businesspostermaker.data.response.generalEvent.GeneralEventDto
import meet.anayacoders.businesspostermaker.data.response.poster.PosterDto
import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventDto
import meet.anayacoders.businesspostermaker.domain.model.GeneralEvent
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.model.UpcomingEvent

fun PosterDto.toPoster(): Poster {
    return Poster(
        id = id,
        title = title,
        category = category,
        imageUrl = imageUrl,
        type = description,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}

fun Poster.toPosterDto(): PosterDto {
    return PosterDto(
        category = category,
        description = type,
        title = title,
        imageUrl = imageUrl,
        id = id,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}

fun UpcomingEventDto.toUpcomingEvent(): UpcomingEvent {
    return UpcomingEvent(
        category = category,
        description = description,
        title = title,
        imageUrl = imageUrl,
        id = id,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}


fun UpcomingEvent.toUpcomingEventDto(): UpcomingEventDto {
    return UpcomingEventDto(
        category = category,
        description = description,
        title = title,
        imageUrl = imageUrl,
        id = id,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}
fun GeneralEventDto.toGeneralEvent(): GeneralEvent {
    return GeneralEvent(
        category = category,
        description = description,
        title = title,
        imageUrl = imageUrl,
        id = id,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}


fun GeneralEvent.toGeneralEventDto(): GeneralEventDto {
    return GeneralEventDto(
        category = category,
        description = description,
        title = title,
        imageUrl = imageUrl,
        id = id,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}