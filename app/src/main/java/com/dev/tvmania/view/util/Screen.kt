package com.dev.tvmania.view.util

sealed class Screen(val route: String){

    object  LoginScreen : Screen(route = "loginScreen")

    object HomeScreen: Screen(route = "home")

    object TvShowDetailScreen: Screen(route = "tvShow/{tvShowId}")

}
