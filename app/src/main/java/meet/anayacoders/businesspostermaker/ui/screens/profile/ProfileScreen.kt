package meet.anayacoders.businesspostermaker.ui.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Profile Screen", fontSize = 32.sp)
    }
}