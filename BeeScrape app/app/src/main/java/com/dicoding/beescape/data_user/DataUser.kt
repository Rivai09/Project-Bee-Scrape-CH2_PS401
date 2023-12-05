package com.dicoding.beescape.data_user

data class DataUser(
    val email: String,
    val token: String,
    var isLogin: Boolean = false
)
