package com.dicoding.beescape.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Market : Screen("market")
    object Notification : Screen("notification")
    object Profile : Screen("profile")

    object SelectMarketplace : Screen("selectmarketplace/{id}") {
        fun createRoute1(id: String?) = "selectmarketplace/$id"
    }

    object Detail : Screen("detail/{id}") {
        fun createRoute2(id: String?) = "detail/$id"
    }


    object TermsCondition:Screen("terms")

    object PrivacyPolicy:Screen("privacy")

    companion object {
        const val LOGOUT_ROUTE = "logout"
    }


}
