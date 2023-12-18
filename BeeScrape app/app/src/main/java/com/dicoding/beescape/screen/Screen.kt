package com.dicoding.beescape.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Market : Screen("market")
    object Notification : Screen("notification")
    object Profile : Screen("profile")

    object SelectMarketplace : Screen("Home/{id}") {
        fun createRoute1(id: String) = "Home/$id"
    }

    object Detail : Screen("SelectMarketplace/{id},{source}") {
        fun createRoute2(id: String, source: String) = "SelectMarketplace/$id,$source"
    }

    object TermsCondition:Screen("terms")

    object PrivacyPolicy:Screen("privacy")

    companion object {
        const val LOGOUT_ROUTE = "logout"
        const val CHANGE_PASSWORD_ROUTE = "change_password"
    }


}
