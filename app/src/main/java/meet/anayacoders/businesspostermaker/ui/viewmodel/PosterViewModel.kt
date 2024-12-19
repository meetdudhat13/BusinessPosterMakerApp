package meet.anayacoders.businesspostermaker.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.model.PosterCategoryItem
import meet.anayacoders.businesspostermaker.domain.usecases.posters.AddNewPosterUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.posters.DeletePosterUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.posters.GetAllPostersUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.posters.SearchPosterByCategoryUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.posters.SearchPosterByCombinedSearchUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.posters.SearchPosterByTitleUseCase
import meet.anayacoders.businesspostermaker.domain.usecases.posters.UpdatePosterUseCase
import meet.anayacoders.businesspostermaker.ui.uistate.AddPosterUiState
import meet.anayacoders.businesspostermaker.ui.uistate.PosterUiState
import javax.inject.Inject

@HiltViewModel
class PosterViewModel @Inject constructor(
    private val getAllPostersUseCase: GetAllPostersUseCase,
    private val addNewPosterUseCase: AddNewPosterUseCase,
    private val deletePosterUseCase: DeletePosterUseCase,
    private val updatePosterUseCase: UpdatePosterUseCase,
    private val searchPosterByTitleUseCase: SearchPosterByTitleUseCase,
    private val searchPosterByCategoryUseCase: SearchPosterByCategoryUseCase,
    private val searchPosterByCombinedSearchUseCase: SearchPosterByCombinedSearchUseCase
) : ViewModel() {
//    private val _allPosters = mutableStateOf<List<Poster>>(emptyList())
//    val allPoster: State<List<Poster>> = _allPosters

    var posterUiState by mutableStateOf(PosterUiState())
        private set

    var addPosterUiState by mutableStateOf(AddPosterUiState())
        private set

//    var selectedPoster by mutableStateOf<Poster?>(null)
//        private set


    init {
        getAllPosters()
//        getAllPostersByCategory()
    }


//    fun onEvent(event: GeneralEvent) {
//        when (event) {
//            is GeneralEvent.OnPosterSelected -> _posterUiState.value = _posterUiState.value.copy(selectedPoster = event.poster)
//        }
//    }

    fun selectedPoster(poster: Poster?) {
//        println("from viewmodel $poster")
//        posterUiState = posterUiState.copy(selectedPoster = poster)
        posterUiState = posterUiState.copy(selectedPoster = poster)
    }

    fun selectedCategory(posterCategoryItem: PosterCategoryItem) {
//        println("from viewmodel $poster")
        posterUiState = posterUiState.copy(selectedCategory = posterCategoryItem)
//        selectedPoster = poster
    }


    fun getAllPosters() {
        viewModelScope.launch {
            posterUiState = posterUiState.copy(isLoading = true)
            val posters = getAllPostersUseCase()
            if (posters.data == null) {
                posterUiState = posterUiState.copy(isLoading = false)
                posterUiState = posterUiState.copy(error = posters.message)
                posterUiState = posterUiState.copy(posters = null)
            } else {
                posterUiState = posterUiState.copy(isLoading = false)
                posterUiState = posterUiState.copy(posters = posters.data)
                posterUiState = posterUiState.copy(categories = posters.data.groupBy { it.category }
                    .map { (category, posterList) ->
                        PosterCategoryItem(catName = category, posters = posterList)
                    })
                posterUiState = posterUiState.copy(error = null)
            }
        }

    }

//    private fun getAllPostersByCategory() {
//        viewModelScope.launch {
//            posterUiState = posterUiState.copy(isLoading = true)
//            val posters = getAllPostersUseCase()
//            if (posters.data == null) {
//                posterUiState = posterUiState.copy(isLoading = false)
//                posterUiState = posterUiState.copy(error = posters.message)
//            } else {
//                posterUiState = posterUiState.copy(isLoading = false)
//                posterUiState = posterUiState.copy(categories = posters.data.groupBy { it.category }
//                    .map { (category, posterList) ->
//                        CategoryItem(catName = category, posters = posterList)
//                    })
//            }
//        }
//    }

    fun addNewPoster(poster: Poster) {
        viewModelScope.launch {
            addPosterUiState = addPosterUiState.copy(isLoading = true)
            val resp = addNewPosterUseCase(poster)
            if (resp.data != null) {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                addPosterUiState = addPosterUiState.copy(success = resp.data.status)
                addPosterUiState = addPosterUiState.copy(error = "")
            } else {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                addPosterUiState =
                    addPosterUiState.copy(error = resp.message ?: "Error")
                addPosterUiState = addPosterUiState.copy(success = "")

            }
            getAllPosters()
        }
    }

    fun deletePoster(poster: Poster) {
        viewModelScope.launch {
            addPosterUiState = addPosterUiState.copy(isLoading = true)
            val resp = deletePosterUseCase(poster)
            if (resp.data != null) {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                addPosterUiState = addPosterUiState.copy(success = resp.data.status)
                addPosterUiState = addPosterUiState.copy(error = "")

            } else {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                addPosterUiState =
                    addPosterUiState.copy(error = resp.message ?: "Error")
                addPosterUiState = addPosterUiState.copy(success = "")

            }
            getAllPosters()
        }
    }

    fun updatePoster(poster: Poster) {
        viewModelScope.launch {
            addPosterUiState = addPosterUiState.copy(isLoading = true)
            val resp = updatePosterUseCase(poster)
            if (resp.data != null) {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                addPosterUiState = addPosterUiState.copy(success = resp.data.status)
                addPosterUiState = addPosterUiState.copy(error = "")

            } else {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                addPosterUiState =
                    addPosterUiState.copy(error = resp.message ?: "Error")
                addPosterUiState = addPosterUiState.copy(success = "")

            }
            getAllPosters()
        }
    }

    fun searchPosterByCombinedSearch(poster: String) {
        viewModelScope.launch {
            addPosterUiState = addPosterUiState.copy(isLoading = true)
            val resp = searchPosterByCombinedSearchUseCase(poster)
            if (resp.data != null) {
                println(resp.data)
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                posterUiState = posterUiState.copy(query = poster)
                posterUiState =
                    posterUiState.copy(searchedPosterList = resp.data.groupBy { it.category }
                        .map { (category, posterList) ->
                            PosterCategoryItem(catName = category, posters = posterList)
                        })
                addPosterUiState = addPosterUiState.copy(error = "")

            } else {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                posterUiState = posterUiState.copy(query = "")
                addPosterUiState =
                    addPosterUiState.copy(error = resp.message ?: "Error")
                posterUiState =
                    posterUiState.copy(searchedPosterList = null)
            }
        }
    }

    fun searchPosterByCategory(poster: String) {
        viewModelScope.launch {
            addPosterUiState = addPosterUiState.copy(isLoading = true)
            val resp = searchPosterByCategoryUseCase(poster)
            if (resp.data != null) {
                println(resp.data)
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                posterUiState = posterUiState.copy(query = poster)
                posterUiState =
                    posterUiState.copy(searchedPosterList = resp.data.groupBy { it.category }
                        .map { (category, posterList) ->
                            PosterCategoryItem(catName = category, posters = posterList)
                        })
                addPosterUiState = addPosterUiState.copy(error = "")

            } else {
                addPosterUiState = addPosterUiState.copy(isLoading = false)
                posterUiState = posterUiState.copy(query = "")
                addPosterUiState =
                    addPosterUiState.copy(error = resp.message ?: "Error")
                posterUiState =
                    posterUiState.copy(searchedPosterList = null)
            }
        }
    }


}