package meet.anayacoders.businesspostermaker.data.mapper

import meet.anayacoders.businesspostermaker.data.dto.PosterDto
import meet.anayacoders.businesspostermaker.data.response.PosterMS
import meet.anayacoders.businesspostermaker.domain.model.Poster

fun PosterDto.toPoster(): Poster {
    return Poster(
        id = id,
        title = title,
        category = category,
        imageUrl = imageUrl,
        description = description,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}
fun PosterMS.toPoster(): Poster {
    return Poster(
        id = id,
        title = title,
        category = category,
        imageUrl = imageUrl,
        description = description,
        tags = tags,
        timestamp = timestamp,
        language = language
    )
}