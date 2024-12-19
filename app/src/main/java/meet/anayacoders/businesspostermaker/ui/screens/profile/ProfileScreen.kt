package meet.anayacoders.businesspostermaker.ui.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import meet.anayacoders.businesspostermaker.domain.model.VisibilityModel
import meet.anayacoders.businesspostermaker.ui.screens.edit.PosterDesignerApp
import meet.anayacoders.businesspostermaker.ui.theme.msdBlackPure
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle

@Preview
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .padding(16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile",
            style = screenHeaderTitleTextStyle,
            modifier = Modifier
                .fillMaxWidth(),
            color = msdBlackPure,
            textAlign = TextAlign.Start,
        )
        Box {
            AsyncImage(
                model = "https://res.cloudinary.com/dpaxrmwmx/image/upload/v1733890032/m_igweug.jpg",
                contentDescription = "",
                modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp),
                contentScale = ContentScale.Crop
            )
            PosterDesignerApp(visibilityModel = VisibilityModel(
                true,
                true,
                true,
                true,
                true,
                true,
            ))
        }
    }
}