package meet.anayacoders.businesspostermaker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val screenHeaderTitleTextStyle  = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    color = Color.Black

)
val eventLabelHomeTextStyle  = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold,
)
val eventLabelViewAllHomeTextStyle  = TextStyle(
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
)
val categoryLabelTextStyle  = TextStyle(
    fontSize = 12.sp,
    fontWeight = FontWeight.Bold,
    color = Color(0xff808080)
)