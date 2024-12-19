package meet.anayacoders.businesspostermaker.domain.model

data class Poster (
    val category: String,
    val type: String,
    val id: String,
    val imageUrl: String,
    val language: String,
    val tags: List<String>,
    val timestamp: String,
    val title: String
)