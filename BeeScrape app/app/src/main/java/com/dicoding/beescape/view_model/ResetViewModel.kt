package com.dicoding.beescape.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.beescape.data_user.DataUser
import com.dicoding.beescape.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ResetViewModel(private val repository: UserRepository) : ViewModel() {

    var successMessage: String? = null

    suspend fun reset(token:String,oldPw:String,newPw:String,confirmPw:String) {
        try {

            val response = repository.resetPassword(token,oldPw, newPw,confirmPw)

            Log.d("resetViewModel", "Permintaan login berhasil.")


        } catch (e: HttpException) {
            Log.e("resetViewModel", "Kesalahan saat melakukan permintaan reset: ${e.message()}")

        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
    fun getSession(): LiveData<DataUser> {
        return repository.getSession().asLiveData()
    }
}