package meet.anayacoders.businesspostermaker

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel


data class FrameConfig(
    val logoPosition: Position,
    val namePosition: Position,
    val contactPosition: Position,
    val emailPosition: Position,
    val backgroundResId: Int
)

data class Position(
    val alignment: Alignment,
    val offsetX: Float,
    val offsetY: Float
)

data class BusinessData(
    val name: String,
    val contact: String,
    val email: String
)


val frameConfigs = listOf(
    FrameConfig(
        logoPosition = Position(Alignment.TopCenter, 0f, 50f),
        namePosition = Position(Alignment.Center, 0f, -100f),
        contactPosition = Position(Alignment.BottomStart, 16f, -50f),
        emailPosition = Position(Alignment.BottomEnd, -16f, -50f),
        backgroundResId = R.drawable.festival_background_1 // Replace with your actual drawable
    ),
    FrameConfig(
        logoPosition = Position(Alignment.TopStart, 16f, 16f),
        namePosition = Position(Alignment.TopCenter, 0f, 100f),
        contactPosition = Position(Alignment.CenterStart, 16f, 0f),
        emailPosition = Position(Alignment.CenterEnd, -16f, 0f),
        backgroundResId = R.drawable.festival_background_2 // Replace with your actual drawable
    )
    // Add more configurations as needed
)


@Composable
fun FrameContent(frameConfig: FrameConfig, businessData: BusinessData) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = frameConfig.backgroundResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Logo
        Image(
            painter = painterResource(id = R.drawable.business_logo), // Replace with actual logo drawable
            contentDescription = "Logo",
            modifier = Modifier
                .size(50.dp)
                .align(frameConfig.logoPosition.alignment)
                .offset(frameConfig.logoPosition.offsetX.dp, frameConfig.logoPosition.offsetY.dp)
        )

        // Organization Name
        Text(
            text = businessData.name,
            color = Color.White,
            modifier = Modifier
                .align(frameConfig.namePosition.alignment)
                .offset(frameConfig.namePosition.offsetX.dp, frameConfig.namePosition.offsetY.dp)
        )

        // Contact Number
        Text(
            text = "Contact: ${businessData.contact}",
            color = Color.White,
            modifier = Modifier
                .align(frameConfig.contactPosition.alignment)
                .offset(
                    frameConfig.contactPosition.offsetX.dp,
                    frameConfig.contactPosition.offsetY.dp
                )
        )

        // Email
        Text(
            text = "Email: ${businessData.email}",
            color = Color.White,
            modifier = Modifier
                .align(frameConfig.emailPosition.alignment)
                .offset(frameConfig.emailPosition.offsetX.dp, frameConfig.emailPosition.offsetY.dp)
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FrameSwipeView(businessData: BusinessData) {
    val pagerState = rememberPagerState(pageCount = { frameConfigs.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val frameConfig = frameConfigs[page]
        FrameContent(frameConfig = frameConfig, businessData = businessData)
    }
}


@Composable
fun PosterDesignerApp() {
    val businessData = BusinessData(
        name = "My Organization",
        contact = "+91 1234567890",
        email = "contact@myorganization.com"
    )

    Column(
        modifier = Modifier.size(400.dp)
    ) {
        FrameSwipeView(businessData = businessData)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPosterDesignerApp(viewModel: PosterViewModel = hiltViewModel()) {
    val items by viewModel.allPoster
    println(items)
    PosterDesignerApp()
}