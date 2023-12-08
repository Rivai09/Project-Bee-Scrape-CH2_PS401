package com.dicoding.beescape

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dicoding.beescape.navigation.NavigationItem
import com.dicoding.beescape.screen.Screen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dicoding.beescape.before_login.WelcomeActivity
import com.dicoding.beescape.screen.page.HomeScreen
import com.dicoding.beescape.screen.page.MarkedScreen
import com.dicoding.beescape.screen.page.NotificationScreen
import com.dicoding.beescape.screen.page.ProfileScreen
import com.dicoding.beescape.screen.page.ProfileScreen
import com.dicoding.beescape.screen.page.SelectMarketplace

@Composable
fun BeeScrapeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }
            composable(Screen.SelectMarketplace.route){
                SelectMarketplace()
            }
            composable(Screen.Marked.route) {
                MarkedScreen()
            }
            composable(Screen.Notification.route){
                NotificationScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(Screen.LOGOUT_ROUTE){
                val intent = Intent(LocalContext.current, WelcomeActivity::class.java)
                LocalContext.current.startActivity(intent)
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.title_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.title_marked),
                icon = Icons.Default.List,
                screen = Screen.Marked
            ),
            NavigationItem(
                stringResource(R.string.title_notifications),
                Icons.Default.Notifications,
                Screen.Notification
            ),
            NavigationItem(
                stringResource(R.string.title_profile),
                Icons.Default.AccountCircle,
                Screen.Profile
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}