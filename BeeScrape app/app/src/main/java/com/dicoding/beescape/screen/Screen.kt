package com.dicoding.beescape.screen

sealed class Screen (val route :String) {
    object Home:Screen("home")
    object Marked:Screen("marked")
    object Notification:Screen("notification")
    object Profile:Screen("profile")
    object SelectMarketplace:Screen("selectMarketplace")
    object DetailCharacter:Screen("home/{id}"){
        fun createRoute(id: Long)="home/$id"
    }
}
