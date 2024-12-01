package meet.anayacoders.businesspostermaker.data.dto

data class PosterDto(
    val id : String,
    val title: String,
    val category: String,
    val imageUrl: String,
    val description: String,
    val tags : List<String>,
    val timestamp: String,
    val language: String,
)
