package com.example.firstjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstjetpackcompose.screen.BottomNavigationBar
import com.example.firstjetpackcompose.screen.BottomNavigationItem
import com.example.firstjetpackcompose.screen.cart.CartScreen
import com.example.firstjetpackcompose.screen.ExtensionScreen
import com.example.firstjetpackcompose.screen.FavouriteScreen
import com.example.firstjetpackcompose.screen.ProfileScreen
import com.example.firstjetpackcompose.screen.home.HomeScreen
import com.example.firstjetpackcompose.ui.theme.FirstJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var itemSelected by remember {
                mutableStateOf(BottomNavigationItem.HOME)
            }
            FirstJetpackComposeTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(onClick = {
                            itemSelected = it
                            navController.navigate(itemSelected.label) {
                                // Tránh việc đẩy lại cùng 1 màn hình
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }, itemSelected = itemSelected)
                    }
                ) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavigationItem.HOME.label,
                    ) {
                        composable(BottomNavigationItem.HOME.label) { HomeScreen() }
                        composable(BottomNavigationItem.FAVOURITE.label) { FavouriteScreen() }
                        composable(BottomNavigationItem.STORE.label) { CartScreen() }
                        composable(BottomNavigationItem.EXTENSION.label) { ExtensionScreen() }
                        composable(BottomNavigationItem.PROFILE.label) { ProfileScreen() }
                    }
                }
            }
        }
    }
}