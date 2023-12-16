package com.dicoding.beescape.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Market : Screen("market")
    object Notification : Screen("notification")
    object Profile : Screen("profile")
    object SelectMarketplace : Screen("selectMarketplace")
    object Detail : Screen("home/{id}") {
        fun createRoute(id: Long) = "home/$id"

    }
    object TermsCondition:Screen("terms")

    object PrivacyPolicy:Screen("privacy")

    companion object {
        const val LOGOUT_ROUTE = "logout"
    }


}
