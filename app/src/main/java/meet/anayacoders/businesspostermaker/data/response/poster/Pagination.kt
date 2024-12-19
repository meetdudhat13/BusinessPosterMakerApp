package meet.anayacoders.businesspostermaker.data.response.poster

data class Pagination(
    val current_page: Int,
    val items_per_page: Int,
    val total_items: Int,
    val total_pages: Int
)