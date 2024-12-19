package meet.anayacoders.businesspostermaker.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import meet.anayacoders.businesspostermaker.domain.model.PosterCategoryItem
import meet.anayacoders.businesspostermaker.ui.theme.categoryLabelCardItemTextStyle


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PosterCategoryCardItem(poster: PosterCategoryItem, onClick: () -> Unit, onLongPress: (Boolean) -> Unit) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
//            .width(120.dp)

    ) {
        AsyncImage(
            modifier = Modifier
//                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally)
                .combinedClickable(
                    onClick = {
                        onClick()
                    },
                    onLongClick = {
                        onLongPress(true)
                    }
                ),
//            contentScale = ContentScale.Crop,
            model = poster.posters[0].imageUrl,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = poster.catName,
            maxLines = 1,
            color = Color.Black,
            overflow = TextOverflow.Ellipsis,
            style = categoryLabelCardItemTextStyle,
            modifier = Modifier.fillMaxWidth(),
//                .background(Color.Yellow),
            textAlign = TextAlign.Center
        )
    }
}