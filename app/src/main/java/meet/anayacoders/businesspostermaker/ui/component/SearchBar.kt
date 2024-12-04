package meet.anayacoders.businesspostermaker.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBarMSD(
    modifier: Modifier, isEnable:Boolean, query: String, onValueChanged: (String) -> Unit
) {
    Row {
        TextField(value = query,
            onValueChange = onValueChanged,
            modifier = modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            enabled = isEnable,
            shape = RoundedCornerShape(8.dp),
            placeholder = { Text("Search Upcoming Event Here...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = ""
                )
            })
    }
}
