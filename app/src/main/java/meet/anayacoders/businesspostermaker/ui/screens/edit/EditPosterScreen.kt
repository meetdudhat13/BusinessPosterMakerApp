package meet.anayacoders.businesspostermaker.ui.screens.edit

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.launch
import meet.anayacoders.businesspostermaker.R
import meet.anayacoders.businesspostermaker.domain.model.VisibilityModel
import meet.anayacoders.businesspostermaker.other.Constants
import meet.anayacoders.businesspostermaker.ui.theme.editPosterUtilsTextStyle
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdWhiteDull
import meet.anayacoders.businesspostermaker.ui.theme.msdWhitePure
import meet.anayacoders.businesspostermaker.ui.theme.screenHeaderTitleTextStyle
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.Calendar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditPosterScreen(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit,
    posterViewModel: PosterViewModel
) {
    val posterUiState = posterViewModel.posterUiState

    val context = LocalContext.current.applicationContext
    val scope = rememberCoroutineScope()
    val captureController = rememberCaptureController()

    var isContactVisible by remember {
        mutableStateOf(true)
    }
    var isEmailVisible by remember {
        mutableStateOf(true)
    }
    var isWebsiteVisible by remember {
        mutableStateOf(true)
    }
    var isAddressVisible by remember {
        mutableStateOf(true)
    }
    var isLogoVisible by remember {
        mutableStateOf(true)
    }
    var isNameVisible by remember {
        mutableStateOf(true)
    }
    var isPosterSaved by remember {
        mutableStateOf(false)
    }


    if (posterUiState.selectedPoster != null) {

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(msdGreen),
            ) {
                IconButton(
                    onClick = {
                        onBackPress()
                    },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = msdWhiteDull
                    )
                }
                Text(
                    text = "Edit Poster",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    color = msdWhiteDull,
                    textAlign = TextAlign.Center,
                    style = screenHeaderTitleTextStyle
                )
            }

            // Poster preview
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .capturable(captureController)
            ) {
                AsyncImage(
                    model = posterUiState.selectedPoster.imageUrl,
                    contentDescription = "",
                    modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp),
                    contentScale = ContentScale.Crop
                )
                PosterDesignerApp(
                    visibilityModel =
                    VisibilityModel(
                        isLogoVisible = isLogoVisible,
                        isNameVisible = isNameVisible,
                        isContactVisible = isContactVisible,
                        isEmailVisible = isEmailVisible,
                        isWebsiteVisible = isWebsiteVisible,
                        isAddressVisible = isAddressVisible,
                    )
                )
            }

            //Edit poster utils
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp, vertical = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logo_default),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isLogoVisible)
                                    msdGreen
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                            .clickable {
                                isLogoVisible = !isLogoVisible
                            }
                            .padding(8.dp),
                        tint = if (isLogoVisible) msdWhitePure else msdGreen
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Logo",
                        style = editPosterUtilsTextStyle,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_brand_default),
                        contentDescription = "Brand Name",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isNameVisible)
                                    msdGreen
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                            .clickable {
                                isNameVisible = !isNameVisible
                            }
                            .padding(8.dp),
                        tint = if (isNameVisible) msdWhitePure else msdGreen
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Name",
                        style = editPosterUtilsTextStyle,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_phone_default),
                        contentDescription = "Contact no",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isContactVisible)
                                    msdGreen
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                            .clickable {
                                isContactVisible = !isContactVisible
                            }
                            .padding(8.dp),
                        tint = if (isContactVisible) msdWhitePure else msdGreen
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Contact",
                        style = editPosterUtilsTextStyle,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email_default),
                        contentDescription = "Email",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isEmailVisible)
                                    msdGreen
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                            .clickable {
                                isEmailVisible = !isEmailVisible
                            }
                            .padding(8.dp),
                        tint = if (isEmailVisible) msdWhitePure else msdGreen
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Email",
                        style = editPosterUtilsTextStyle,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_website_default),
                        contentDescription = "Website",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isWebsiteVisible)
                                    msdGreen
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                            .clickable {
                                isWebsiteVisible = !isWebsiteVisible
                            }
                            .padding(8.dp),
                        tint = if (isWebsiteVisible) msdWhitePure else msdGreen
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Website",
                        style = editPosterUtilsTextStyle,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_address_default),
                        contentDescription = "Address",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isAddressVisible)
                                    msdGreen
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                            .clickable {
                                isAddressVisible = !isAddressVisible
                            }
                            .padding(8.dp),
                        tint = if (isAddressVisible) msdWhitePure else msdGreen
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Address",
                        style = editPosterUtilsTextStyle,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            val bitmapAsync = captureController.captureAsync()
                            try {
                                val b = bitmapAsync.await()
                                saveBitmapToStorage(
                                    context,
                                    b.asAndroidBitmap(),
                                    "IMG${Calendar.getInstance().timeInMillis}",
                                    isPosterSaved = {
                                        isPosterSaved = it
                                    }
                                )
                            } catch (error: Throwable) {
                                Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = msdGreen,
                        contentColor = msdWhitePure
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = if (isPosterSaved) R.drawable.ic_save_defaut_filled else R.drawable.ic_save_defaut_outline),
                            contentDescription = "save poster",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Save Poster",
                            modifier = Modifier,
                        )
                    }
                }
            }
        }
    }
}


fun saveBitmapToStorage(
    context: Context,
    bitmap: Bitmap,
    fileName: String,
    isPosterSaved: (Boolean) -> Unit
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        // For Android 10 and above: Using MediaStore for scoped storage
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            put(
                MediaStore.Images.Media.RELATIVE_PATH,
                "Pictures/${Constants.APP_NAME}"
            ) // Stores in Pictures folder
        }

        val contentResolver = context.contentResolver
        val uri =
            contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

        uri?.let {
            try {
                val outputStream: OutputStream? = contentResolver.openOutputStream(it)
                outputStream?.let { it1 -> bitmap.compress(Bitmap.CompressFormat.PNG, 100, it1) }
                outputStream?.flush()
                outputStream?.close()
                Log.d("Bitmap Save", "Image saved to external storage")
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                isPosterSaved(true)
            } catch (e: Exception) {
                Log.e("Bitmap Save", "Failed to save image", e)
                Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show()
                isPosterSaved(false)
            }
        }

    } else {
        // For Android 9 and below: Writing directly to external storage
        val directory = File(context.getExternalFilesDir(null), "${Constants.APP_NAME}/Images")
        if (!directory.exists()) directory.mkdirs()

        val file = File(directory, fileName)
        try {
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            Log.d("Bitmap Save", "Image saved to external storage")
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
            isPosterSaved(true)
        } catch (e: Exception) {
            Log.e("Bitmap Save", "Failed to save image", e)
            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show()
            isPosterSaved(false)

        }
    }
}