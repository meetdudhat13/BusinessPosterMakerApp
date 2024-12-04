package meet.anayacoders.businesspostermaker.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import meet.anayacoders.businesspostermaker.ui.component.BottomNavItems
import meet.anayacoders.businesspostermaker.ui.screens.category.CategoryScreen
import meet.anayacoders.businesspostermaker.ui.screens.creates.CreatesScreen
import meet.anayacoders.businesspostermaker.ui.screens.home.HomeScreen
import meet.anayacoders.businesspostermaker.ui.screens.home.SearchScreen
import meet.anayacoders.businesspostermaker.ui.screens.profile.ProfileScreen
import meet.anayacoders.businesspostermaker.ui.theme.msdGray
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.Category,
        BottomNavItems.Creates,
        BottomNavItems.Profile,
    )
    Scaffold(
        bottomBar = {
//            BottomNavBarMsd(navController = navController, items = items)
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route

            if (currentRoute in listOf(
                    BottomNavItems.Home.route,
                    BottomNavItems.Category.route,
                    BottomNavItems.Creates.route,
                    BottomNavItems.Profile.route,
                )
            ) {
                NavigationBar {
                    items
                        .forEach { navigationItem ->
                            val isSelected = currentRoute == navigationItem.route

                            NavigationBarItem(
                                selected = isSelected,
                                label = {
                                    Text(text = navigationItem.label)
                                },
                                onClick = {
                                    navController.navigate(navigationItem.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {

                                    Icon(
                                        painter = painterResource(navigationItem.unSelectedIcon!!),
                                        contentDescription = navigationItem.label,
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = msdGreen,
                                    unselectedIconColor = msdGray,
                                    unselectedTextColor = msdGray,
                                    selectedTextColor = msdGreen,
                                    indicatorColor = Color.Transparent,
                                )
                            )
                        }
                }
            }
        }
    ) { ip ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Home.route,
            modifier = Modifier.padding(ip)
        ) {
            composable(BottomNavItems.Home.route) {
                HomeScreen(onSearchClick = {
                    navController.navigate(BottomNavItems.Search.route)
                })
            }
            composable(BottomNavItems.Category.route) {
                CategoryScreen()
            }
            composable(BottomNavItems.Creates.route) {
                CreatesScreen()
            }
            composable(BottomNavItems.Profile.route) {
                ProfileScreen()
            }
            composable(BottomNavItems.Search.route) {
                SearchScreen()
            }
        }
    }
}