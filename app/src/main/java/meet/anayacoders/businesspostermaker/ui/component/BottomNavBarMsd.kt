package meet.anayacoders.businesspostermaker.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import meet.anayacoders.businesspostermaker.ui.theme.msdGray
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen


@Composable
fun BottomNavBarMsd(
    navController: NavController,
    items: List<BottomNavItems>
) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            Column(
                modifier = Modifier
                    .clickable {
                        if (!isSelected) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter =  painterResource(
                        id = item.unSelectedIcon!!
                    ),
                    contentDescription = item.label,
                    tint = if (isSelected) msdGreen else msdGray,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = item.label,
                    color =if (isSelected) msdGreen else msdGray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }


}