package meet.anayacoders.businesspostermaker.data.response.poster

data class PosterDataDto(
    val pagination: Pagination,
    val posters: List<PosterDto>
)