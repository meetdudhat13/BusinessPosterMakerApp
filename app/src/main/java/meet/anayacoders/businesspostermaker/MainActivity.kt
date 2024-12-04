package meet.anayacoders.businesspostermaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import meet.anayacoders.businesspostermaker.ui.screens.MainScreen
import meet.anayacoders.businesspostermaker.ui.screens.home.HomeScreen
import meet.anayacoders.businesspostermaker.ui.theme.BusinessPosterMakerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessPosterMakerTheme {
                    MainScreen()
            }
        }
    }
}


