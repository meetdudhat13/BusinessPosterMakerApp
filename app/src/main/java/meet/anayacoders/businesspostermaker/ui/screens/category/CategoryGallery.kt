package meet.anayacoders.businesspostermaker.ui.screens.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import meet.anayacoders.businesspostermaker.ui.component.PosterCardItem
import meet.anayacoders.businesspostermaker.ui.theme.categoryLabelCardItemTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.categoryLabelTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.eventLabelViewAllHomeTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdWhiteDull
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel

@Composable
fun CategoryGallery(
    modifier: Modifier = Modifier,
    posterViewModel: PosterViewModel,
    onClick: () -> Unit,
    onBackPress: () -> Unit,
    onNextButtonClick:()->Unit
) {
    val posterUiState = posterViewModel.posterUiState

    if (posterUiState.selectedCategory != null) {
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
                IconButton(
                    onClick = {
                        onBackPress()
                    },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = msdWhiteDull
                    )
                }
                Text(
                    text = posterUiState.selectedCategory.catName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    color = msdWhiteDull,
                    textAlign = TextAlign.Center,
                    style = screenHeaderTitleTextStyle
                )

                Text(
                    text = "Next", color = msdGreen, modifier = Modifier
                        .padding(end = 16.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .clickable {
                            onNextButtonClick()
                        }
                        .background(msdWhiteDull)
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .align(Alignment.CenterEnd),
                    style = categoryLabelCardItemTextStyle

                )

            }
            Box(
                modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp)
            ) {
                if (posterUiState.selectedPoster != null) {
                    AsyncImage(
                        model = posterUiState.selectedPoster.imageUrl,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        onLoading = {
                            //Show shimmer logo
                        },
                        onError = {
                            //Show shimmer logo
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = (8.dp),
                modifier = Modifier
                    .padding(16.dp),
                //TODO: replace 21 number with the size of the list
                //                        .height(((posterUiState.posters.size / 3) + if (posterUiState.posters.size % 3 == 0) 0 else 1).dp * 146),
                //                    userScrollEnabled = false
            ) {
                items(posterUiState.selectedCategory.posters) {
                    PosterCardItem(
                        poster = it,
                        onClick = {
                            //                                onEvent(GeneralEvent.OnPosterSelected(it))
                            //                                viewModel.onEvent(GeneralEvent.OnPosterSelected(it))
                            posterViewModel.selectedPoster(it)
                            onClick()
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