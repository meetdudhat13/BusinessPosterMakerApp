package meet.anayacoders.businesspostermaker.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import meet.anayacoders.businesspostermaker.R
import meet.anayacoders.businesspostermaker.domain.model.Poster
import meet.anayacoders.businesspostermaker.ui.theme.categoryLabelTextStyle


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PosterCardItem(poster: Poster, onClick: () -> Unit, onLongPress: (Boolean) -> Unit) {
    var isImgLoading by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(modifier = Modifier) {
            AsyncImage(
                modifier = Modifier
//                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.Center)
                    .combinedClickable(
                        onClick = {
                            onClick()
                        },
                        onLongClick = {
                            onLongPress(true)
                        }
                    ),
                onLoading = {
                    isImgLoading = true
                },
                onSuccess = {
                    isImgLoading = false
                },
                onError = {
                    isImgLoading = false
                },
                model = poster.imageUrl.ifEmpty {
                    R.drawable.img
                },
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            if (isImgLoading)
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = poster.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = categoryLabelTextStyle,
            modifier = Modifier.fillMaxWidth(),
//                .background(Color.Yellow),
            textAlign = TextAlign.Center
        )
    }
}