package meet.anayacoders.businesspostermaker.domain.model

data class UpcomingEvent(
    val category: String,
    val description: String,
    val id: String,
    val imageUrl: String,
    val language: String,
    val tags: List<String>,
    val timestamp: String,
    val title: String
    )