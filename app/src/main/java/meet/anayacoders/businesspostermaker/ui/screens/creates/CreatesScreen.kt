package meet.anayacoders.businesspostermaker.ui.screens.creates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.theme.msdWhiteDull

@Composable
fun CreatesScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(msdWhiteDull)
    ) {
        Text(
            text = "Coming Soon :)",
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            color = msdGreen,
            textAlign = TextAlign.Center
        )
    }
}