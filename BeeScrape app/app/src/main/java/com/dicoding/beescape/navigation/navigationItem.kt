package com.dicoding.beescape.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.dicoding.beescape.screen.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)