package meet.anayacoders.businesspostermaker.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import meet.anayacoders.businesspostermaker.ui.component.SearchBarMSD

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
//            .verticalScroll(rememberScrollState())
    ) {
        SearchBarMSD(
            modifier = modifier
                .padding(top = 16.dp)
                .clickable {
                }, query = searchQuery,
            isEnable = true
        ) {
            searchQuery = it
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 16.dp)
                //TODO: replace 21 number with the size of the list
//                .height(((21 / 3) + if (21 % 3 == 0) 0 else 1).dp * 146),
//            userScrollEnabled = false
        ) {
            items(50) {
                CardItem()
            }
        }
    }
}