package meet.anayacoders.businesspostermaker.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import meet.anayacoders.businesspostermaker.ui.component.PosterCategoryCardItem
import meet.anayacoders.businesspostermaker.ui.component.SearchBarMSD
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdWhiteDull
import meet.anayacoders.businesspostermaker.ui.theme.msdWhitePure
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: PosterViewModel,
    onClick: () -> Unit,
    onBackPress:()->Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val posterUiState = viewModel.posterUiState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(msdGreen),
        ) {
            IconButton(onClick = {
                onBackPress()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = msdWhiteDull
                )
            }
            Text(
                text = "Search Events",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                color = msdWhiteDull,
                textAlign = TextAlign.Center,
                style = screenHeaderTitleTextStyle
            )
        }

        SearchBarMSD(
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .clickable {
                }, query = searchQuery,
            isEnable = true,
            hintText = "Search Event here...",
            onValueChanged = {

                searchQuery = it
            },
            search = {
                if (searchQuery.isNotEmpty()) {
                    //TODO: viewModel search for category
                    viewModel.searchPosterByCombinedSearch(searchQuery)
                }
            }
        )
        when {
            posterUiState.isLoading -> {
                Box(modifier = Modifier.weight(1f)) {
                    CircularProgressIndicator()
                }
            }

            !posterUiState.isLoading && posterUiState.searchedPosterList != null -> {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        //TODO: replace 21 number with the size of the list
                        .height(((50 / 3) + if (50 % 3 == 0) 0 else 1).dp * 146),
                    userScrollEnabled = false
                ) {
                    items(posterUiState.searchedPosterList) {
                        PosterCategoryCardItem(poster = it, onClick = {
//                                onEvent(GeneralEvent.OnPosterSelected(it))
//                                viewModel.onEvent(GeneralEvent.OnPosterSelected(it))
                            viewModel.selectedCategory(it)
                            viewModel.selectedPoster(it.posters[0])
                            onClick()
                        },
                            onLongPress = { isLongPressed ->
//                                isPosterDeleteDialogVisible = isLongPressed
//                                itemType = Constants.ITEM_TYPE_GENERAL_EVENT
//                                longPressedPoster = it
                            })
                    }
                }
            }

            !posterUiState.isLoading && posterUiState.error != null -> {
                Text(text = "Something went wrong!!")
            }
        }
    }
}
