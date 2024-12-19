package meet.anayacoders.businesspostermaker.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import meet.anayacoders.businesspostermaker.ui.screens.MainScreen
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


