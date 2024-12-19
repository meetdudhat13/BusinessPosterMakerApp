package meet.anayacoders.businesspostermaker.ui.screens.home

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import meet.anayacoders.businesspostermaker.ui.component.PosterCategoryCardItem
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdWhiteDull
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel
import meet.anayacoders.businesspostermaker.ui.viewmodel.UpcomingEventViewModel

@Composable
fun UpcomingEventGallery(
    modifier: Modifier = Modifier,
    upcomingEventViewModel: UpcomingEventViewModel,
    posterViewModel: PosterViewModel,
    onClick: () -> Unit,
    onBackPress: () -> Unit
) {
    val generalEventUiState = posterViewModel.posterUiState


    if (generalEventUiState.searchedPosterList != null) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
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
                    text = generalEventUiState.query,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    color = msdWhiteDull,
                    textAlign = TextAlign.Center,
                    style = screenHeaderTitleTextStyle
                )
            }
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = (16.dp),
                modifier = Modifier
                    .padding(16.dp)
                //TODO: replace 21 number with the size of the list
                //                        .height(((posterUiState.posters.size / 3) + if (posterUiState.posters.size % 3 == 0) 0 else 1).dp * 146),
                //                    userScrollEnabled = false
            ) {
                items(generalEventUiState.searchedPosterList) {
                    PosterCategoryCardItem(
                        poster = it,
                        onClick = {
                            posterViewModel.selectedCategory(it)
                            posterViewModel.selectedPoster(it.posters[0])
                            onClick()
                        },
                        onLongPress = {}
                    )
                }
            }
        }
    }

}