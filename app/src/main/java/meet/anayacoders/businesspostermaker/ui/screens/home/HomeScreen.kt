package meet.anayacoders.businesspostermaker.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import meet.anayacoders.businesspostermaker.R
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.ui.component.GeneralEventCategoryCardItem
import meet.anayacoders.businesspostermaker.ui.component.SearchBarMSD
import meet.anayacoders.businesspostermaker.ui.component.ShimmerListItem
import meet.anayacoders.businesspostermaker.ui.component.UpcomingEventCardItem
import meet.anayacoders.businesspostermaker.ui.theme.eventLabelHomeTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdRed
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle
import meet.anayacoders.businesspostermaker.ui.viewmodel.GeneralEventViewModel
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel
import meet.anayacoders.businesspostermaker.ui.viewmodel.UpcomingEventViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit,
    onUpcomingEventClick: () -> Unit,
    onGeneralEventClick: () -> Unit,
    posterViewModel: PosterViewModel,
    generalEventViewModel: GeneralEventViewModel,
    upComingEventViewModel: UpcomingEventViewModel
) {

    val generalEventUiState = generalEventViewModel.generalEventUiState
    val upcomingEventUiState = upComingEventViewModel.upcomingEventUiState

    var searchQuery by remember { mutableStateOf("") }

    val pagerState = rememberPagerState(pageCount = { 5 })

    var isPosterDeleteDialogVisible by remember {
        mutableStateOf(false)
    }

    var itemType by remember {
        mutableStateOf("")
    }
    var longPressedPoster by remember {
        mutableStateOf(
            Poster(
                id = "msd",
                title = "meet",
                category = "festival",
                imageUrl = "dudhat",
                type = "description",
                tags = arrayListOf("msd", "dudhat", "meet"),
                timestamp = "timeStamp",
                language = "Gujarati"
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
//            .background(Color.Red)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
    ) {

        HomeScreenHeader(businessName = "Anaya Coders", logo = R.drawable.img, onRefresh = {
            upComingEventViewModel.getAllUpcomingEvent()
            generalEventViewModel.getAllGeneralEvents()
        })

        SearchBarMSD(
            modifier = modifier
                .padding(top = 16.dp)
                .clickable {
                    onSearchClick()
                    posterViewModel.searchPosterByCombinedSearch("")
                }, query = searchQuery,
            isEnable = false,
            hintText = "Search Event here...",
            onValueChanged = {
                searchQuery = it

            },
            search = {}
        )

//        HorizontalPager(
//            state = pagerState,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp),
//            pageSpacing = 16.dp
//        ) {
//            BannerPagerItem(image = R.drawable.sample, onLongPress = { isLongPressed ->
////                isPosterDeleteDialogVisible = isLongPressed
////                itemType = Constants.ITEM_TYPE_BANNER
//            })
//        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
//                .background(Color.Cyan),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Upcoming Events", style = eventLabelHomeTextStyle, color = msdRed
            )
//            Text(
//                text = "View All",
//                style = eventLabelViewAllHomeTextStyle,
//                color = Color.White,
//                modifier = Modifier
//                    .clip(RoundedCornerShape(4.dp))
//                    .background(msdGreen)
//                    .padding(8.dp)
//            )

        }

        //Upcoming Events List

        when {
            upcomingEventUiState.isLoading -> LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
                    //TODO: replace 21 number with the size of the list
                    .height(((9 / 3) + if (9 % 3 == 0) 0 else 1).dp * 146),
                userScrollEnabled = false
            ) {
                items(9) {
                    ShimmerListItem()
                }
            }

            upcomingEventUiState.error != null -> Text(text = upcomingEventUiState.error)

            upcomingEventUiState.events != null -> {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        //TODO: replace 21 number with the size of the list
                        .height(((upcomingEventUiState.events.size / 3) + if (upcomingEventUiState.events.size % 3 == 0) 0 else 1).dp * 146),
                    userScrollEnabled = false

                ) {
                    items(upcomingEventUiState.events.sortedBy { it.timestamp.toLong() }) {
                        UpcomingEventCardItem(
                            event = it,
                            onClick = {
//                        onEvent(GeneralEvent.OnPosterSelected(it))
//                                upComingEventViewModel.selectedPoster(it)
                                posterViewModel.searchPosterByCategory(it.category)
                                onUpcomingEventClick()
                            },
                            onLongPress = { isLongPressed ->
//                                isPosterDeleteDialogVisible = isLongPressed
//                                itemType = Constants.ITEM_TYPE_UPCOMING_EVENT
                            }
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
//                .background(Color.Cyan),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "General Events", style = eventLabelHomeTextStyle, color = msdGreen
            )
//            Text(
//                text = "View All",
//                style = eventLabelViewAllHomeTextStyle,
//                color = Color.White,
//                modifier = Modifier
//                    .clip(RoundedCornerShape(4.dp))
//                    .background(msdGreen)
//                    .padding(8.dp)
//            )

        }

// General Event List
        when {
            generalEventUiState.isLoading -> LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
                    //TODO: replace 21 number with the size of the list
                    .height(((6 / 3) + if (6 % 3 == 0) 0 else 1).dp * 146),
                userScrollEnabled = false
            ) {
                items(6) {
                    ShimmerListItem()
                }
            }

            generalEventUiState.error != null -> Text(text = generalEventUiState.error)

            generalEventUiState.categories != null -> {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        //TODO: replace 21 number with the size of the list
                        .height(((generalEventUiState.categories.size / 3) + if (generalEventUiState.categories.size % 3 == 0) 0 else 1).dp * 146),
                    userScrollEnabled = false
                ) {
                    items(generalEventUiState.categories) {
                        GeneralEventCategoryCardItem(
                            event = it,
                            onClick = {
                                generalEventViewModel.searchEventByCategory(it.catName)
                                onGeneralEventClick()
                            },
                            onLongPress = {
                            }
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun HomeScreenHeader(
    modifier: Modifier = Modifier,
    businessName: String,
    logo: Int,
    onRefresh: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
//            .background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Text(
            text = businessName, style = screenHeaderTitleTextStyle
        )
        Box(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .clickable(
                ) {
                    onRefresh()
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_gallery_unselected),
                contentDescription = "logo",
                tint = msdGreen,
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_loop_selected),
                contentDescription = "logo",
                tint = msdGreen,
                modifier = Modifier
                    .size(40.dp)
                    .offset(0.dp, (-2).dp)
                    .align(Alignment.Center)
            )
        }
    }
}





