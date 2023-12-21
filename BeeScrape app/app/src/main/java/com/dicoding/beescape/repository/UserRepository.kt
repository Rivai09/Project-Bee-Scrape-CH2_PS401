package com.dicoding.beescape.repository

import com.dicoding.beescape.api.response.ItemsItem
import com.dicoding.beescape.api.response.LoginResponse
import com.dicoding.beescape.api.response.MainResponse
import com.dicoding.beescape.api.response.SignUpResponse
import com.dicoding.beescape.api.retrofit.ApiService
import com.dicoding.beescape.data_user.DataUser
import com.dicoding.beescape.data_user.UserPreference
import kotlinx.coroutines.flow.Flow

class UserRepository private constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {

    suspend fun saveSession(user: DataUser) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<DataUser> {
        return userPreference.getSession()
    }

//    fun getDataPaging(token: String): Flow<PagingData<ItemsItem>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 5
//            ),
//            pagingSourceFactory = {
//                PagingSource(apiService, "Bearer $token")
//            }
//        ).flow
//    }

    //    suspend fun getDataState(token: String) = liveData {
//        emit(UiState.Loading)
//
//        try {
//            val response = apiService.getDataPaging("Bearer $token")
//            emit(response.items?.let { UiState.Success(it) })
//            Log.d("user repo","berhasil get data")
//        } catch (e: Exception) {
//            Log.e("User repository", "Failed to load data", e)
//            emit(UiState.Error("Failed to load data"))
//        }
//    }

    suspend fun fetchData(token: String):MainResponse {
        return apiService.getData("Bearer $token")
    }

    suspend fun getDetail(token:String, id: String): ItemsItem? {
        return apiService.getDetail("Bearer $token",id)
    }


    suspend fun logout() {
        userPreference.logout()
    }


    suspend fun register(name: String, email: String, password: String): SignUpResponse {
        return apiService.register(name, email, password)
    }

    suspend fun login(email: String, password: String): LoginResponse {
        return apiService.login(email, password)
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference, apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference, apiService)
            }.also { instance = it }
    }

}