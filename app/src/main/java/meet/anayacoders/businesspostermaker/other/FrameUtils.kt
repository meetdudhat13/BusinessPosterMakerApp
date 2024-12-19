package meet.anayacoders.businesspostermaker.other

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import meet.anayacoders.businesspostermaker.R
import meet.anayacoders.businesspostermaker.domain.model.frame.FrameConfig
import meet.anayacoders.businesspostermaker.domain.model.frame.Position
import meet.anayacoders.businesspostermaker.ui.theme.fontFamilyMsd

object FrameUtils {

    val frameConfigs = listOf(
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f), // Relative positions
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd
            ),
            contactPosition = Position(Alignment.BottomStart, 0.02f, -0.052f),
            contactTextStyle = TextStyle(
                fontSize = 9.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.Normal
            ),
            emailPosition = Position(Alignment.BottomEnd, -0.02f, -0.03f),
            emailTextStyle = TextStyle(
                fontSize = 9.sp, color = Color.White, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.Normal
            ),
            addressPosition = Position(
                alignment = Alignment.BottomStart,
                offsetX = 0.02f,
                offsetY = -0.006f
            ),
            addressTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            websitePosition = Position(
                alignment = Alignment.BottomStart,
                offsetX = 0.02f,
                offsetY = -0.03f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 9.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.Normal
            ),
            websiteIconTint = Color.White,
            contactIconTint = Color.White,
            emailIconTint = Color.White,
            showContactIcon = true,
            showEmailIcon = true,
            showWebsiteIcon = true,
            showAddressIcon = true,
            backgroundResId = R.drawable.frame_a
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,

                ),
            contactPosition = Position(Alignment.BottomCenter, 0f, -0.028f),
            contactTextStyle = TextStyle(
                fontSize = 9.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            addressPosition = Position(Alignment.BottomCenter, 0f, -0.0015f),
            addressTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.Black,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(Alignment.BottomStart, 0f, -0.021f),
            emailTextStyle = TextStyle(
                fontSize = 8.sp, color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            websitePosition = Position(
                alignment = Alignment.BottomEnd,
                offsetX = -0f,
                offsetY = -0.021f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 8.sp, color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            backgroundResId = R.drawable.frame_b
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(Alignment.BottomEnd, -0.07f, -0.04f),
            contactTextStyle = TextStyle(
                fontSize = 9.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(Alignment.BottomStart, 0.07f, -0.054f),
            emailTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.006f
            ),
            addressTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            websitePosition = Position(
                alignment = Alignment.BottomStart,
                offsetX = 0.07f,
                offsetY = -0.033f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 8.sp, color = Color.White, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            websiteIconTint = Color.White,
            showContactIcon = true,
            showEmailIcon = true,
            showWebsiteIcon = true,
            showAddressIcon = true,
            backgroundResId = R.drawable.frame_c
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            namePosition = Position(Alignment.BottomCenter, 0f, -0.047f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(Alignment.BottomStart, 0.01f, -0.022f),
            contactTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(Alignment.BottomCenter, 0.03f, -0.023f),
            emailTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                color = Color.White,
                fontWeight = FontWeight.SemiBold

            ),
            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.001f
            ),
            addressTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            websitePosition = Position(
                alignment = Alignment.TopStart,
                offsetX = 0.01f,
                offsetY = 0.015f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 8.sp, color = Color.White, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            websiteIconTint = Color.White,
            emailIconTint = Color.White,
//        showContactIcon = true,
            showEmailIcon = true,
            showWebsiteIcon = true,
            showAddressIcon = true,
            backgroundResId = R.drawable.frame_f
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.04f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.02f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(Alignment.BottomStart, 0.09f, -0.0305f),
            contactTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(Alignment.BottomEnd, -0.09f, -0.0305f),
            emailTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                color = Color.White,
                fontWeight = FontWeight.SemiBold

            ),
            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.006f
            ),
            addressTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            showAddressIcon = true,
            backgroundResId = R.drawable.frame_e
        ),
        FrameConfig(
            namePosition = Position(Alignment.TopCenter, 0f, 0.002f),
            nameTextStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(Alignment.BottomStart, 0.185f, -0.007f),
            contactTextStyle = TextStyle(
                fontSize = 7.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(Alignment.BottomStart, 0.465f, -0.007f),
            emailTextStyle = TextStyle(
                fontSize = 7.sp, fontFamily = fontFamilyMsd,
                color = Color.White,
                fontWeight = FontWeight.SemiBold

            ),
            addressPosition = Position(
                alignment = Alignment.BottomStart,
                offsetX = 0.035f,
                offsetY = -0.0225f
            ),
            addressTextStyle = TextStyle(
                fontSize = 7.sp, fontFamily = fontFamilyMsd,
                color = Color.White,
                fontWeight = FontWeight.SemiBold

            ),
            backgroundResId = R.drawable.frame_h
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.04f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.02f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(Alignment.BottomStart, 0.08f, -0.031f),
            contactTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            addressPosition = Position(
                alignment = Alignment.BottomStart,
                offsetX = 0.235f,
                offsetY = -0.006f
            ),
            addressTextStyle = TextStyle(
                fontSize = 7.sp, fontFamily = fontFamilyMsd,
                color = Color.White,
                fontWeight = FontWeight.SemiBold

            ),
            backgroundResId = R.drawable.frame_i
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(
                Alignment.BottomStart,
                0.08f,
                -0.028f
            ),
            contactTextStyle = TextStyle(
                fontSize = 8.sp,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.01f
            ),
            addressTextStyle = TextStyle(
                fontSize = (7.5).sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            websitePosition = Position(
                alignment = Alignment.BottomEnd,
                offsetX = -0.08f,
                offsetY = -0.028f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 8.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            showContactIcon = true,
            showEmailIcon = true,
            showWebsiteIcon = true,
            showAddressIcon = true,
            backgroundResId = R.drawable.frame_j
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.BottomCenter, 0f, -0.048f),
            nameTextStyle = TextStyle(
                fontSize = 10.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(
                Alignment.BottomCenter,
                0f,
                -0.028f
            ),
            contactTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(
                alignment = Alignment.BottomEnd,
                offsetX = -0.03f,
                offsetY = -0.029f
            ),
            emailTextStyle = TextStyle(
                fontSize = 7.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            websitePosition =
            Position(
                Alignment.BottomStart,
                0.03f,
                -0.029f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 7.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),
            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.005f
            ),
            addressTextStyle = TextStyle(
                fontSize = 7.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold

            ),

            showContactIcon = true,
            contactIconTint = Color.White,
            showEmailIcon = true,
            emailIconTint = Color.White,
            showWebsiteIcon = true,
            websiteIconTint = Color.White,
            showAddressIcon = true,
            backgroundResId = R.drawable.frame_l
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(
                Alignment.BottomStart,
                0.16f,
                -0.045f
            ),
            contactTextStyle = TextStyle(
                fontSize = 10.sp,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0.15f,
                offsetY = -0.034f
            ),
            emailTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.011f
            ),
            addressTextStyle = TextStyle(
                fontSize = 7.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            showContactIcon = true,
            contactIconTint = Color(0xfff07821),
            showEmailIcon = true,
            emailIconTint = Color.White,
            showWebsiteIcon = true,
            showAddressIcon = true,
            addressIconTint = Color(0xfff07821),
            backgroundResId = R.drawable.frame_n
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(
                Alignment.BottomCenter,
                0.0f,
                -0.025f
            ),
            contactTextStyle = TextStyle(
                fontSize = 9.sp,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            websitePosition = Position(
                alignment = Alignment.BottomStart,
                offsetX = 0.02f,
                offsetY = -0.0255f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 7.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(
                alignment = Alignment.BottomEnd,
                offsetX = -0.03f,
                offsetY = -0.0255f
            ),
            emailTextStyle = TextStyle(
                fontSize = 7.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.004f
            ),
            addressTextStyle = TextStyle(
                fontSize = 7.sp, fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            showContactIcon = true,
            contactIconTint = Color(0xff393186),
            showEmailIcon = true,
            emailIconTint = Color.White,
            showWebsiteIcon = true,
            websiteIconTint = Color.White,
            showAddressIcon = true,
            addressIconTint = Color(0xff393186),
            backgroundResId = R.drawable.frame_o
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(
                Alignment.BottomStart,
                0.1f,
                -0.03f
            ),
            contactTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            websitePosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0.08f,
                offsetY = -0.03f
            ),
            websiteTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.006f
            ),
            addressTextStyle = TextStyle(
                fontSize = 7.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            showContactIcon = true,
            contactIconTint = Color.White,
            showEmailIcon = true,
            showWebsiteIcon = true,
            websiteIconTint = Color.White,
            showAddressIcon = true,
            addressIconTint = Color.White,
            backgroundResId = R.drawable.frame_p
        ),
        FrameConfig(
            logoPosition = Position(Alignment.TopStart, 0.05f, 0.02f),
            namePosition = Position(Alignment.TopEnd, -0.05f, 0.02f),
            nameTextStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamilyMsd,
            ),
            contactPosition = Position(
                Alignment.BottomStart,
                0.13f,
                -0.053f
            ),
            contactTextStyle = TextStyle(
                fontSize = 8.sp,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),
            emailPosition = Position(
                Alignment.BottomStart,
                0.13f,
                -0.03f
            ),
            emailTextStyle = TextStyle(
                fontSize = 8.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            addressPosition = Position(
                alignment = Alignment.BottomCenter,
                offsetX = 0f,
                offsetY = -0.005f
            ),
            addressTextStyle = TextStyle(
                fontSize = 7.sp,
                color = Color.White,
                fontFamily = fontFamilyMsd,
                fontWeight = FontWeight.SemiBold
            ),

            showContactIcon = true,
            showEmailIcon = true,
            emailIconTint = Color.White,
            showWebsiteIcon = true,
            showAddressIcon = true,
            addressIconTint = Color.White,
            backgroundResId = R.drawable.frame_r
        ),
    )
}