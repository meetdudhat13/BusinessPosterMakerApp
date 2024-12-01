package meet.anayacoders.businesspostermaker.data.response

data class PosterMS(
    val __v: Int,
    val _id: String,
    val category: String,
    val description: String,
    val id: String,
    val imageUrl: String,
    val language: String,
    val tags: List<String>,
    val timestamp: String,
    val title: String
)