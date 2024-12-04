package meet.anayacoders.businesspostermaker.ui.screens.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendModeColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meet.anayacoders.businesspostermaker.ui.component.SearchBarMSD
import meet.anayacoders.businesspostermaker.ui.screens.home.CardItem
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = "Event Categories", style = screenHeaderTitleTextStyle,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            items(50) {
                CardItem()
            }
        }
    }
}