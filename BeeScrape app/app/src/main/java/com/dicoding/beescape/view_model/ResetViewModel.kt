package com.dicoding.beescape.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.beescape.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ResetViewModel(private val repository: UserRepository) : ViewModel() {

    private var successMessage: String? = null

    suspend fun reset(oldPw:String,newPw:String,confirmPw:String) {
        try {

            val response = repository.resetPassword(oldPw, newPw,confirmPw)

            Log.d("resetViewModel", "Permintaan login berhasil.")

            successMessage = response.message
            if (successMessage.toBoolean()){
                logout()
            }


        } catch (e: HttpException) {
            Log.e("resetViewModel", "Kesalahan saat melakukan permintaan login: ${e.message()}")

        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}