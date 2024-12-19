package meet.anayacoders.businesspostermaker.ui.uistate

import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.model.PosterCategoryItem

data class PosterUiState(
    val isLoading: Boolean = false,
    val posters: List<Poster>? = null,
    val error: String? = null,
    val query: String = "",
    val selectedPoster: Poster? = null,
    val selectedPosterForPreview: Poster? = null,
    val isEmpty: Boolean = false,
    val languageFilter: String = "",
    val categories: List<PosterCategoryItem>? = null,
    val searchedPosterList: List<PosterCategoryItem>? = null,
    val selectedCategory: PosterCategoryItem? = null,
)