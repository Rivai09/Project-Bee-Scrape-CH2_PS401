package com.dicoding.beescape

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.dicoding.beescape.screen.page.AnalysisScreen
import com.dicoding.beescape.screen.page.Detail
import com.dicoding.beescape.screen.page.HomeScreen
import com.dicoding.beescape.screen.page.NotificationScreen
import com.dicoding.beescape.screen.page.ProfileScreen
import com.dicoding.beescape.screen.page.SelectMarketplace
import com.dicoding.beescape.screen.page.TermsScreen

@Composable
fun BeeScrapeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController,selectedColor = Color.Yellow)
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
                SelectMarketplace ({navController.navigate(Screen.Detail.route)},navController)
            }
            composable(Screen.Detail.route){
                Detail()
            }
            composable(Screen.Market.route) {
                AnalysisScreen(navController)
            }
            composable(Screen.Notification.route){
                NotificationScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(Screen.TermsCondition.route){
                TermsScreen()
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
    selectedColor: Color = Color.Yellow,
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
                title = stringResource(R.string.analisis_market),
                icon = Icons.Default.ShoppingCart,
                screen = Screen.Market
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
        navigationItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (currentRoute == item.screen.route) selectedColor else LocalContentColor.current
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (currentRoute == item.screen.route) selectedColor else LocalContentColor.current
                    )
                },
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