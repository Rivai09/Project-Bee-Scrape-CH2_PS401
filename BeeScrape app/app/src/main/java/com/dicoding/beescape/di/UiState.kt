package com.dicoding.beescape.di

import com.dicoding.beescape.api.response.ItemsItem

sealed class UiState<out T: Any?> {

    object Loading : UiState<Nothing>()

    data class Success<out T: Any>(val data: ItemsItem) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}
