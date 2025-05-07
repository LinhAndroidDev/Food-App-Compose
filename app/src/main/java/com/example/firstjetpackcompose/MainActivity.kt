package com.example.firstjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstjetpackcompose.screen.BottomNavigationBar
import com.example.firstjetpackcompose.screen.BottomNavigationItem
import com.example.firstjetpackcompose.screen.cart.CartScreen
import com.example.firstjetpackcompose.screen.ExtensionScreen
import com.example.firstjetpackcompose.screen.FavouriteScreen
import com.example.firstjetpackcompose.screen.ProfileScreen
import com.example.firstjetpackcompose.screen.detail_food.DetailFoodScreen
import com.example.firstjetpackcompose.screen.home.HomeScreen
import com.example.firstjetpackcompose.screen.map.TrackingScreen
import com.example.firstjetpackcompose.ui.theme.FirstJetpackComposeTheme
import com.example.firstjetpackcompose.viewmodel.ShareViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val sharedViewModel: ShareViewModel = viewModel()
            var itemSelected by remember {
                mutableStateOf(BottomNavigationItem.HOME)
            }
            FirstJetpackComposeTheme {
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                val screenRoute = navBackStackEntry?.destination?.route ?: ""
                Scaffold(
                    bottomBar = {
                        if (BottomNavigationItem.isScreenBottomNavigation(screenRoute)) {
                            BottomNavigationBar(onClick = {
                                itemSelected = it
                                navController.navigate(itemSelected.label) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }, itemSelected = itemSelected)
                        } else {
                            Spacer(modifier = Modifier.fillMaxWidth())
                        }
                    }
                ) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavigationItem.HOME.label,
                    ) {
                        composable(BottomNavigationItem.HOME.label) { HomeScreen(navController, sharedViewModel) }
                        composable(BottomNavigationItem.FAVOURITE.label) { FavouriteScreen() }
                        composable(BottomNavigationItem.STORE.label) { CartScreen(navController, sharedViewModel) }
                        composable(BottomNavigationItem.EXTENSION.label) { ExtensionScreen() }
                        composable(BottomNavigationItem.PROFILE.label) { ProfileScreen() }
                        composable("detail_food") { DetailFoodScreen(navController, sharedViewModel) }
                        composable("tracking") { TrackingScreen(navController) }
                    }
                }
            }
        }
    }
}