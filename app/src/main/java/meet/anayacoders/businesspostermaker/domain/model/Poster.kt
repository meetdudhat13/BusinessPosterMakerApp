package meet.anayacoders.businesspostermaker.domain.model

data class Poster (
    val id : String,
    val title: String,
    val category: String,
    val imageUrl: String,
    val description: String,
    val tags : List<String>,
    val timestamp: String,
    val language: String,
)