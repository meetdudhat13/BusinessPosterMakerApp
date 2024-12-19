package meet.anayacoders.businesspostermaker.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import meet.anayacoders.businesspostermaker.ui.component.GeneralEventCardItem
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdWhitePure
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle
import meet.anayacoders.businesspostermaker.ui.viewmodel.GeneralEventViewModel

@Composable
fun GeneralEventGallery(
    modifier: Modifier = Modifier,
    generalEventViewModel: GeneralEventViewModel,
    onClick: () -> Unit
) {
    val generalEventUiState = generalEventViewModel.generalEventUiState

    if (generalEventUiState.searchedEventList != null) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = generalEventUiState.searchedEventList[0].category,
                style = screenHeaderTitleTextStyle,
                modifier = Modifier
                    .background(msdGreen)
                    .padding(16.dp)
                    .fillMaxWidth(),
                color = msdWhitePure,
                textAlign = TextAlign.Center
            )
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = (16.dp),
                modifier = Modifier
                    .padding(16.dp),
                //TODO: replace 21 number with the size of the list
                //                        .height(((posterUiState.posters.size / 3) + if (posterUiState.posters.size % 3 == 0) 0 else 1).dp * 146),
                //                    userScrollEnabled = false
            ) {
                items(generalEventUiState.searchedEventList) {
                    GeneralEventCardItem(
                        event = it,
                        onClick = {
                            generalEventViewModel.selectedPoster(it)
                            onClick()
                        },
                        onLongPress = {}
                    )
                }
            }
        }
    }

}