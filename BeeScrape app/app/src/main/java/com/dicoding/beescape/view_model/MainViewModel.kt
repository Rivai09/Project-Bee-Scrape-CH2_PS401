package com.dicoding.beescape.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dicoding.beescape.api.response.ItemsItem
import com.dicoding.beescape.data_user.DataUser
import com.dicoding.beescape.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository) : ViewModel() {

    fun getSession(): LiveData<DataUser> {
        return repository.getSession().asLiveData()
    }

    fun getDataPaging(token: String): Flow<PagingData<ItemsItem>> = repository.getDataPaging(token).cachedIn(viewModelScope)

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

}