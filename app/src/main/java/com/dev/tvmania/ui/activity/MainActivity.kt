package com.dev.tvmania.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.tvmania.view.presentation.HomeScreen
import com.dev.tvmania.viewModel.HomeViewModel
import com.dev.tvmania.view.presentation.TvShowDetailScreen
import com.dev.tvmania.viewModel.TvShowDetailViewModel
import com.dev.tvmania.ui.theme.TvManiaTheme
import com.dev.tvmania.view.loginScreen.LoginScreen
import com.dev.tvmania.view.util.Screen
import com.dev.tvmania.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {

            val navController = rememberNavController()

            val uriHandler = LocalUriHandler.current

            TvManiaTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.LoginScreen.route
                    ) {
                        composable(route= Screen.LoginScreen.route){
                            LoginScreen(LoginViewModel(),navController)
                        }
                        composable(route = Screen.HomeScreen.route) {
                            val homeViewModel = hiltViewModel<HomeViewModel>()
                            HomeScreen(
                                viewModel = homeViewModel,
                                onTvShowClick = { id ->
                                    navController.navigate(route = "tvShow/$id")
                                }
                            )
                        }
                        composable(route = Screen.TvShowDetailScreen.route) {
                            val tvShowDetailViewModel = hiltViewModel<TvShowDetailViewModel>()
                            TvShowDetailScreen(
                                viewModel = tvShowDetailViewModel,
                                onBackPress = { navController.popBackStack() },
                                onWatchNowClick = { uriHandler.openUri(uri = it) }
                            )
                        }
                    }
                }
            }
        }
    }
}

