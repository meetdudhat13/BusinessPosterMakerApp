package meet.anayacoders.businesspostermaker.ui.screens.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meet.anayacoders.businesspostermaker.R
import meet.anayacoders.businesspostermaker.domain.model.VisibilityModel
import meet.anayacoders.businesspostermaker.domain.model.frame.BusinessData
import meet.anayacoders.businesspostermaker.domain.model.frame.FrameConfig
import meet.anayacoders.businesspostermaker.other.FrameUtils.frameConfigs


@Composable
fun FrameContent(
    frameConfig: FrameConfig,
    businessData: BusinessData,
    visibilityModel: VisibilityModel
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    fun scaleOffsetX(relativeOffset: Float) = (screenWidth * relativeOffset).value.dp
    fun scaleOffsetY(relativeOffset: Float) = (screenHeight * relativeOffset).value.dp

    val scaleFactor = screenWidth.value / 360f // Assume 360dp as the baseline width

    fun scaledFontSize(baseSize: TextUnit): TextUnit {
        return (baseSize.value * scaleFactor).sp
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = frameConfig.backgroundResId),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )

        // Logo
        if (visibilityModel.isLogoVisible) {
            frameConfig.logoPosition?.let {
                Image(
                    painter = painterResource(id = R.drawable.business_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(50.dp * scaleFactor)
                        .align(it.alignment)
                        .offset(scaleOffsetX(it.offsetX), scaleOffsetY(it.offsetY))
                )
            }
        }

        // Name
        if (visibilityModel.isNameVisible) {

            frameConfig.namePosition?.let {
                Text(
                    text = businessData.name,
                    style = frameConfig.nameTextStyle.copy(
                        fontSize = scaledFontSize(frameConfig.nameTextStyle.fontSize)
                    ),
                    modifier = Modifier
                        .align(it.alignment)
                        .offset(scaleOffsetX(it.offsetX), scaleOffsetY(it.offsetY))
                )
            }
        }
        // Contact Number
        if (visibilityModel.isContactVisible) {

            frameConfig.contactPosition?.let {
                Row(
                    modifier = Modifier
                        .align(it.alignment)
                        .offset(scaleOffsetX(it.offsetX), scaleOffsetY(it.offsetY)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (frameConfig.showContactIcon) {
                        Icon(
                            painter = painterResource(id = frameConfig.contactIcon),
                            contentDescription = "Contact Icon",
                            modifier = Modifier.size(10.dp * scaleFactor),
                            tint = frameConfig.contactIconTint
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp * scaleFactor))
                    Text(
                        text = businessData.contact,
                        style = frameConfig.contactTextStyle.copy(
                            fontSize = scaledFontSize(frameConfig.contactTextStyle.fontSize)
                        )
                    )
                }
            }
        }

        // Email
        if (visibilityModel.isEmailVisible) {
            frameConfig.emailPosition?.let {
                Row(
                    modifier = Modifier
                        .align(it.alignment)
                        .offset(scaleOffsetX(it.offsetX), scaleOffsetY(it.offsetY)),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    if (frameConfig.showEmailIcon) {
                        Icon(
                            painter = painterResource(id = frameConfig.emailIcon),
                            contentDescription = "Email Icon",
                            modifier = Modifier.size(10.dp * scaleFactor),
                            tint = frameConfig.emailIconTint
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp * scaleFactor))
                    Text(
                        text = businessData.email,
                        style = frameConfig.emailTextStyle.copy(
                            fontSize = scaledFontSize(frameConfig.emailTextStyle.fontSize)
                        )
                    )
                }
            }
        }

        // Address
        if (visibilityModel.isAddressVisible) {

            frameConfig.addressPosition?.let {
                Row(
                    modifier = Modifier
                        .align(it.alignment)
                        .offset(scaleOffsetX(it.offsetX), scaleOffsetY(it.offsetY)),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    if (frameConfig.showAddressIcon) {
                        Icon(
                            painter = painterResource(id = frameConfig.addressIcon),
                            contentDescription = "Address Icon",
                            modifier = Modifier.size(10.dp * scaleFactor),
                            tint = frameConfig.addressIconTint
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp * scaleFactor))
                    Text(
                        text = "Shree Annapurnadham boys hostel,adalaj, Gandhinagar, 382421",
                        style = frameConfig.addressTextStyle.copy(
                            fontSize = scaledFontSize(frameConfig.addressTextStyle.fontSize)
                        ),
                    )
                }
            }
        }

        // Website
        if (visibilityModel.isWebsiteVisible) {

            frameConfig.websitePosition?.let {
                Row(
                    modifier = Modifier
                        .align(it.alignment)
                        .offset(scaleOffsetX(it.offsetX), scaleOffsetY(it.offsetY)),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    if (frameConfig.showWebsiteIcon) {
                        Icon(
                            painter = painterResource(id = frameConfig.websiteIcon),
                            contentDescription = "Website Icon",
                            modifier = Modifier.size(10.dp * scaleFactor),
                            tint = frameConfig.websiteIconTint
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp * scaleFactor))
                    Text(
                        text = "www.anayacoders.com",
                        style = frameConfig.websiteTextStyle.copy(
                            fontSize = scaledFontSize(frameConfig.websiteTextStyle.fontSize)
                        ),
                    )
                }
            }
        }
    }
}

@Composable
fun FrameSwipeView(businessData: BusinessData, visibilityModel: VisibilityModel) {
    val pagerState = rememberPagerState(pageCount = { frameConfigs.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val frameConfig = frameConfigs[page]
        FrameContent(
            frameConfig = frameConfig,
            businessData = businessData,
            visibilityModel = visibilityModel
        )
    }
}


@Composable
fun PosterDesignerApp(visibilityModel: VisibilityModel) {
    val businessData = BusinessData(
        name = "Anaya coders",
        contact = "7863054244",
        email = "meetdudhat@gmail.com"
    )

    Box(
        modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp)
    ) {
        FrameSwipeView(businessData = businessData, visibilityModel = visibilityModel)
    }
}

