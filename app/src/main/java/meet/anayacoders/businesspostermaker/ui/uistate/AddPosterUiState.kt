package meet.anayacoders.businesspostermaker.ui.uistate

data class AddPosterUiState(
    val isLoading: Boolean = false,
    val success: String = "",
    val error: String = ""
)