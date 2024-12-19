package meet.anayacoders.businesspostermaker.ui.screens

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import meet.anayacoders.businesspostermaker.ui.component.BottomNavItems
import meet.anayacoders.businesspostermaker.ui.screens.category.CategoryGallery
import meet.anayacoders.businesspostermaker.ui.screens.category.CategoryScreen
import meet.anayacoders.businesspostermaker.ui.screens.creates.CreatesScreen
import meet.anayacoders.businesspostermaker.ui.screens.edit.EditPosterScreen
import meet.anayacoders.businesspostermaker.ui.screens.home.GeneralEventGallery
import meet.anayacoders.businesspostermaker.ui.screens.home.HomeScreen
import meet.anayacoders.businesspostermaker.ui.screens.home.SearchScreen
import meet.anayacoders.businesspostermaker.ui.screens.home.UpcomingEventGallery
import meet.anayacoders.businesspostermaker.ui.screens.profile.ProfileScreen
import meet.anayacoders.businesspostermaker.ui.theme.msdGray
import meet.anayacoders.businesspostermaker.ui.theme.msdGreen
import meet.anayacoders.businesspostermaker.ui.viewmodel.GeneralEventViewModel
import meet.anayacoders.businesspostermaker.ui.viewmodel.PosterViewModel
import meet.anayacoders.businesspostermaker.ui.viewmodel.UpcomingEventViewModel

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

        val statusBarLight = msdGreen
        val isDarkMode = isSystemInDarkTheme()
        val context = LocalContext.current as ComponentActivity
        DisposableEffect(isDarkMode) {
            context.enableEdgeToEdge(
                statusBarStyle = if (!isDarkMode) {
                    SystemBarStyle.light(
                        statusBarLight.hashCode(),
                        statusBarLight.hashCode(),
                    )
                } else {
                    SystemBarStyle.dark(
                        statusBarLight.hashCode()

                    )
                },
            )

            onDispose { }
        }


        val posterViewModel: PosterViewModel = hiltViewModel()
        val upComingEventViewModel: UpcomingEventViewModel = hiltViewModel()
        val generalEventViewModel: GeneralEventViewModel = hiltViewModel()

        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Home.route,
            modifier = Modifier.padding(ip)
        ) {

            composable(BottomNavItems.Home.route) {
                HomeScreen(
                    onSearchClick = {
                        navController.navigate(BottomNavItems.Search.route)
                    },
                    onUpcomingEventClick = {
                        navController.navigate(BottomNavItems.UpcomingEventGallery.route)
                    },
                    onGeneralEventClick = {
                        navController.navigate(BottomNavItems.GeneralEventGallery.route)
                    },
                    posterViewModel = posterViewModel,
                    generalEventViewModel = generalEventViewModel,
                    upComingEventViewModel = upComingEventViewModel
                )
            }
            composable(BottomNavItems.GeneralEventGallery.route) {
                GeneralEventGallery(
                    generalEventViewModel = generalEventViewModel,
                    onClick = {}
                )
            }
            composable(BottomNavItems.UpcomingEventGallery.route) {
                UpcomingEventGallery(
                    upcomingEventViewModel = upComingEventViewModel,
                    posterViewModel = posterViewModel,
                    onClick = {
                        navController.navigate(BottomNavItems.CategoryGallery.route)
                    },
                    onBackPress = {
                        navController.navigateUp()
                    }
                )
            }
            composable(BottomNavItems.Category.route) {
                CategoryScreen(
                    posterViewModel = posterViewModel,
                    onPosterClick = {
                        navController.navigate(BottomNavItems.CategoryGallery.route)
                    }
                )
            }
            composable(BottomNavItems.CategoryGallery.route) {
                CategoryGallery(
                    posterViewModel = posterViewModel,
                    onClick = {},
                    onBackPress = {
                        navController.navigateUp()
                    },
                    onNextButtonClick = {
                        navController.navigate(BottomNavItems.EditPosterScreen.route)
                    }
                )
            }
            composable(BottomNavItems.Creates.route) {
                CreatesScreen(
                    onPosterClick = {},
                    posterViewModel = posterViewModel,
                )
            }
            composable(BottomNavItems.Profile.route) {
                ProfileScreen ()
//                {
//                    navController.navigate(it)
//                }
            }
            composable(BottomNavItems.Search.route) {
                SearchScreen(
                    viewModel = posterViewModel,
                    onClick = {
                        navController.navigate(BottomNavItems.CategoryGallery.route)
                    },
                    onBackPress = {
                        navController.navigateUp()
                    }
                )
            }
            composable(BottomNavItems.EditPosterScreen.route) {
                EditPosterScreen(
                    posterViewModel = posterViewModel,
                    onBackPress = {
                        navController.navigateUp()
                    },
                )
            }
        }
    }
}