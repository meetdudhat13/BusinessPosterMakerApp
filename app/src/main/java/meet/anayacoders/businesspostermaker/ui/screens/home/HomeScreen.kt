package meet.anayacoders.businesspostermaker.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import meet.anayacoders.businesspostermaker.R
import meet.anayacoders.businesspostermaker.ui.component.SearchBarMSD
import meet.anayacoders.businesspostermaker.ui.theme.categoryLabelTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.eventLabelHomeTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.eventLabelViewAllHomeTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdRed
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onSearchClick: () -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val pagerState = rememberPagerState(pageCount = { 5 })


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
//            .background(Color.Red)
            .padding(horizontal = 16.dp),
    ) {
        HomeScreenHeader(businessName = "Anaya Coders", logo = R.drawable.img)


        SearchBarMSD(
            modifier = modifier
                .padding(top = 16.dp)
                .clickable {
                    onSearchClick()
                }, query = searchQuery,
            isEnable = false
        ) {
            searchQuery = it
        }

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            pageSpacing = 16.dp
        ) {
            BannerPagerItem(image = R.drawable.sample)
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
                text = "Upcoming Events",
                style = eventLabelHomeTextStyle,
                color = msdRed
            )
            Text(
                text = "View All",
                style = eventLabelViewAllHomeTextStyle,
                color = Color.White,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(msdGreen)
                    .padding(8.dp)
            )

        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            items(6) {
                CardItem()
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
                text = "General Events",
                style = eventLabelHomeTextStyle,
                color = msdGreen
            )
            Text(
                text = "View All",
                style = eventLabelViewAllHomeTextStyle,
                color = Color.White,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(msdGreen)
                    .padding(8.dp)
            )

        }


        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 16.dp)
                //TODO: replace 21 number with the size of the list
                .height(((21 / 3) + if (21 % 3 == 0) 0 else 1).dp * 146),
            userScrollEnabled = false
        ) {
            items(21) {
                CardItem()
            }
        }


    }
}

@Composable
fun HomeScreenHeader(modifier: Modifier = Modifier, businessName: String, logo: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
//            .background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
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
//                    .background(Color.Cyan)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_gallery_selected),
                contentDescription = "logo",
                modifier = Modifier
                    .size(16.dp)
                    .offset(0.dp, 2.dp)
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_loop_selected),
                contentDescription = "logo",
                modifier = Modifier.size(40.dp)
            )
        }
    }
}


@Composable
fun BannerPagerItem(modifier: Modifier = Modifier, image: Int) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = image),
            contentDescription = ""
        )
    }

}

@Composable
fun CardItem(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .width(120.dp)
    ) {
        Image(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.img),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Happy New Year", style = categoryLabelTextStyle,
            modifier = Modifier
                .fillMaxWidth(),
//                .background(Color.Yellow),
            textAlign = TextAlign.Center
        )
    }
}