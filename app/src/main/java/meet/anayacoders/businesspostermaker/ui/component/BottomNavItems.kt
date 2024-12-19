package meet.anayacoders.businesspostermaker.ui.component

import meet.anayacoders.businesspostermaker.R


sealed class BottomNavItems(
    val route : String,
    val label : String,
    val selectedIcon : Int?,
    val unSelectedIcon : Int?
){
    object Home : BottomNavItems(
        route = "home",
        label = "Home",
        selectedIcon = R.drawable.ic_home_selected,
        unSelectedIcon = R.drawable.ic_home_unselected
    )
    object Category : BottomNavItems(
        route = "category",
        label = "Category",
        selectedIcon = R.drawable.ic_category_selected,
        unSelectedIcon = R.drawable.ic_category_unselected
    )
    object Creates : BottomNavItems(
        route = "creates",
        label = "Creates",
        selectedIcon = R.drawable.ic_edit_poster_selected,
        unSelectedIcon = R.drawable.ic_edit_poster_unselected
    )
    object Profile : BottomNavItems(
        route = "profile",
        label = "Profile",
        selectedIcon = R.drawable.ic_profile_selected,
        unSelectedIcon = R.drawable.ic_profile_unselected
    )
    object Search : BottomNavItems(
        route = "search",
        label = "Search",
        selectedIcon = null,
        unSelectedIcon = null
    )
    object CategoryGallery : BottomNavItems(
        route = "category_gallery",
        label = "Category Gallery",
        selectedIcon = null,
        unSelectedIcon = null
    )
    object GeneralEventGallery : BottomNavItems(
        route = "general_event_gallery",
        label = "General Event Gallery",
        selectedIcon = null,
        unSelectedIcon = null
    )
    object UpcomingEventGallery : BottomNavItems(
        route = "upcoming_event_gallery",
        label = "Upcoming Event Gallery",
        selectedIcon = null,
        unSelectedIcon = null
    )
    object EditPosterScreen : BottomNavItems(
        route = "edit_poster_screen",
        label = "Edit Poster Screen",
        selectedIcon = null,
        unSelectedIcon = null
    )
}