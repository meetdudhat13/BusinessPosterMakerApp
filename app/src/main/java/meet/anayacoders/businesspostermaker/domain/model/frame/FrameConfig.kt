package meet.anayacoders.businesspostermaker.domain.model.frame

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import meet.anayacoders.businesspostermaker.R

data class FrameConfig(
    //Logo position
    val logoPosition: Position? = null,
    //Brand Name
    val namePosition: Position? = null,
    val nameTextStyle: TextStyle = TextStyle.Default, // Add TextStyle for name
    //Contact
    val contactPosition: Position? = null,
    val contactIcon : Int= R.drawable.ic_call_default,
    val contactIconTint: Color = Color.Black,
    val showContactIcon: Boolean = false,
    val contactTextStyle: TextStyle = TextStyle.Default, // Add TextStyle for contact
    //Email
    val emailPosition: Position? = null,
    val emailIcon : Int=  R.drawable.ic_email_default,
    val emailIconTint: Color = Color.Black,
    val showEmailIcon: Boolean = false,
    val emailTextStyle: TextStyle = TextStyle.Default,  // Add TextStyle for email
    //Address
    val addressPosition: Position? = null,
    val addressIcon : Int=  R.drawable.ic_address_default,
    val addressIconTint: Color = Color.Black,
    val showAddressIcon: Boolean = false,
    val addressTextStyle: TextStyle = TextStyle.Default, // Add TextStyle for address
    //Website
    val websitePosition: Position? = null,
    val websiteIcon : Int=  R.drawable.ic_website_default,
    val websiteIconTint: Color = Color.Black,
    val showWebsiteIcon: Boolean = false,
    val websiteTextStyle: TextStyle = TextStyle.Default, // Add TextStyle for website
    //Frame
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