package com.dicoding.beescape

sealed class UiState<out T: Any?> {

    object Loading : UiState<Nothing>()

//    data class Success<out T: Any>(val data: AtributeCharacter?) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}
