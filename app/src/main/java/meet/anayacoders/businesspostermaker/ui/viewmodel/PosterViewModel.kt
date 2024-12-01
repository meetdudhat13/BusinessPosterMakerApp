package meet.anayacoders.businesspostermaker.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.domain.usecases.GetAllPostersUseCase
import javax.inject.Inject

@HiltViewModel
class PosterViewModel @Inject constructor(
    private val getAllPostersUseCase: GetAllPostersUseCase
) : ViewModel() {
    private val _allPosters = mutableStateOf<List<Poster>>(emptyList())
    val allPoster: State<List<Poster>> = _allPosters

    init {
        getAllPosters()
    }

    private fun getAllPosters() {
        viewModelScope.launch {
            _allPosters.value = getAllPostersUseCase()
        }
    }

}