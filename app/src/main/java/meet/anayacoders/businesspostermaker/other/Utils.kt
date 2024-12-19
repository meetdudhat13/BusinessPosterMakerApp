package meet.anayacoders.businesspostermaker.other

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import kotlin.math.ceil

object Utils {

    fun convertMillisToDate(milliseconds: Long): String {
        val date = Date(milliseconds)
        val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return format.format(date)
    }

    fun getDateAndMonth(milliseconds: Long): String {
        val instant = Instant.ofEpochMilli(milliseconds)
        val formatter = DateTimeFormatter.ofPattern("dd MMM").withZone(ZoneId.systemDefault()) // Example: "01 Jan"
        return formatter.format(instant)
    }

    @Composable
    fun calculateLazyVerticalGridHeight(totalItems: Int, cellSizeDp: Int, spacingDp: Int): Int {
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp -16.dp
        val cellSize = cellSizeDp.dp
        val spacing = spacingDp.dp

        // Calculate how many items fit in a single row
        val itemsPerRow = remember(screenWidth, cellSize, spacing) {
            (screenWidth / (cellSize + spacing)).toInt()
        }

        return itemsPerRow
    }

}