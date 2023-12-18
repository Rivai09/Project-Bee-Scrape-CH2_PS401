package com.dicoding.beescape.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.beescape.api.response.DataResponse
import com.dicoding.beescape.api.response.ItemsDetailItem
import com.dicoding.beescape.data_user.DataUser
import com.dicoding.beescape.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository) : ViewModel() {
//    private val dataFlow = MutableStateFlow<PagingData<ItemsItem>>(PagingData.empty())
//    val getDataFlow: Flow<PagingData<ItemsItem>> = dataFlow
//
//    fun getDataLive(token: String) {
//        viewModelScope.launch {
//            repository.getDataPaging(token).collect {
//                dataFlow.value = it
//                Log.d("ViewModel", "Data Flow: ${dataFlow.value}")
//            }
//        }
//    }

//    private val data = MutableLiveData<List<ItemsItem?>?>()
//    val getData: LiveData<List<ItemsItem?>?> = data
//
//
//    fun getDataState(token: String) {
//        viewModelScope.launch {
//            repository.getDataState(token).asFlow().collect {
//                data.postValue(it)
//            }
//        }
//    }

//    private val data = MutableLiveData<List<ItemsItem?>?>()
//    val getData: LiveData<List<ItemsItem?>?> get() = data
//
//
//    fun getDataState(token: String) {
//        viewModelScope.launch {
//            data.value=repository.getDataState(token)
//        }
//    }

//    private val _data = mutableStateOf<MainResponse?>(null)
//    val data: State<MainResponse?> = _data
//
//    fun fetchData(token : String) {
//        viewModelScope.launch {
//            try {
//                _data.value = repository.fetchData(token)
//            } catch (e: Exception) {
//                Log.d("view model","$token")
//            }
//        }
//    }



    private val _data = MutableStateFlow<DataResponse?>(null)
    val getData: MutableStateFlow<DataResponse?> = _data

    fun fetchData(token: String) {
        viewModelScope.launch {
            try {
                _data.value = repository.fetchData(token)
            } catch (e: Exception) {
                Log.d("view model", token)
            }
        }
    }






    private val _dataDetail = mutableStateOf<ItemsDetailItem?>(null)
    val getDataDetail: State<ItemsDetailItem?> = _dataDetail

    fun detailData(token : String,id:String) {
        viewModelScope.launch {
            try {
                _dataDetail.value = repository.getDetail(token,id)
            } catch (e: Exception) {
                Log.d("view model detail","$token $id")
            }
        }
    }



    fun getSession(): LiveData<DataUser> {
        return repository.getSession().asLiveData()
    }

//    private val _searchResults = MutableLiveData<List<ItemsItem>>()
//    val searchResults: LiveData<List<ItemsItem>>
//        get() = _searchResults
//
//    private val _isLoading = MutableLiveData<Boolean>()
//    val isLoading: LiveData<Boolean>
//        get() = _isLoading
//
//    private val _error = MutableLiveData<String>()
//    val error: LiveData<String>
//        get() = _error
//
//    fun search(query: String) {
//        viewModelScope.launch {
//            try {
//                _isLoading.value = true
//                _searchResults.value = repository.searching(query)
//            } catch (e: Exception) {
//                _error.value = "Search failed: ${e.message}"
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

}