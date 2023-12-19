package com.dicoding.beescape.repository

import android.util.Log
import com.dicoding.beescape.api.response.DataResponse
import com.dicoding.beescape.api.response.DetailResponse
import com.dicoding.beescape.api.response.LoginResponse
import com.dicoding.beescape.api.response.ResetResponse
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



    suspend fun fetchData(token: String): DataResponse {
        return apiService.getData("Bearer $token")
    }

    suspend fun getDetail(token:String, id: String): DetailResponse? {
        try {
            //pakai kode jika sudah benar id di api
//            return apiService.getDetail("Bearer $token",id)
            return apiService.getDetail("Bearer $token","6581bdba2235bd336a933fa4")
        }catch (e:Exception){
            if (id.isEmpty()){
                Log.d("repository","$id kosong")
                Log.e("user repo kosong", e.toString())
            }else{
                Log.d("repository","$token kosong/unvalid")
                Log.e("user repo aman tapi", e.toString())
            }
        }
        return null
    }

//    suspend fun searching(query: String): List<ItemsItem> {
//        try {
//            val response = apiService.searchData(query)
//
//            if (response.isSuccessful) {
//                return response.body() ?: emptyList()
//            } else {
//                Log.e("ApiService", "API call failed with code: ${response.code()}")
//            }
//        } catch (e: Exception) {
//            Log.e("ApiService", "Exception during API call", e)
//        }
//
//        return emptyList()
//    }

    suspend fun logout() {
        userPreference.logout()
    }


    suspend fun register(name: String, email: String, password: String): SignUpResponse {
        return apiService.register(name, email, password)
    }

    suspend fun login(email: String, password: String): LoginResponse {
        return apiService.login(email, password)
    }

    suspend fun resetPassword(token:String, oldPw: String, newPw: String, confirmPw: String):ResetResponse{
        return apiService.resetPassword("Bearer $token",oldPw,newPw,confirmPw)
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