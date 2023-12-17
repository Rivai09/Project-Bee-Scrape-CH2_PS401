package com.dicoding.beescape.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Market : Screen("market")
    object Notification : Screen("notification")
    object Profile : Screen("profile")

    object SelectMarketplace : Screen("selectMarketplace/{id}") {
        fun createRoute1(id: String) = "selectMarketplace/$id"
    }

    object Detail : Screen("home/{id}") {
        fun createRoute2(id: String) = "home/$id"
    }
    object TermsCondition:Screen("terms")

    object PrivacyPolicy:Screen("privacy")

    companion object {
        const val LOGOUT_ROUTE = "logout"
    }


}
