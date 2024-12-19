package meet.anayacoders.businesspostermaker.ui.screens.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
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
import meet.anayacoders.businesspostermaker.ui.theme.msdBlackPure
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdWhitePure
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    posterViewModel: PosterViewModel,
    onPosterClick: () -> Unit
) {

    val posterUiState = posterViewModel.posterUiState
    var searchQuery by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Event Categories",
            style = screenHeaderTitleTextStyle,
            modifier = Modifier
//                .background(msdGreen)
//                .padding(16.dp)
                .fillMaxWidth(),
            color = msdBlackPure,
            textAlign = TextAlign.Start,
        )
//
//        SearchBarMSD(
//            modifier = modifier
//                .padding(top =  16.dp)
//                .clickable {
//                }, query = searchQuery,
//            isEnable = true,
//            hintText = "Search Category here..."
//        ) {
//            searchQuery = it
//        }

        when {
            posterUiState.isLoading -> Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            posterUiState.error != null -> Text(text = posterUiState.error)

            posterUiState.categories != null -> {

                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalItemSpacing = 16.dp,
//                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        //TODO: replace 21 number with the size of the list
//                        .height(((posterUiState.categories.size / 3) + if (posterUiState.categories.size % 3 == 0) 0 else 1).dp * 146),
//                    userScrollEnabled = false
                ) {
                    items(posterUiState.categories) {
                        PosterCategoryCardItem(
                            poster = it,
                            onClick = {
//                                onEvent(GeneralEvent.OnPosterSelected(it))
//                                viewModel.onEvent(GeneralEvent.OnPosterSelected(it))
                                posterViewModel.selectedCategory(it)
                                posterViewModel.selectedPoster(it.posters[0])
                                onPosterClick()
                            },
                            onLongPress = { isLongPressed ->
//                                isPosterDeleteDialogVisible = isLongPressed
//                                itemType = Constants.ITEM_TYPE_GENERAL_EVENT
//                                longPressedPoster = it
                            }
                        )
                    }
                }
            }
        }
    }
}