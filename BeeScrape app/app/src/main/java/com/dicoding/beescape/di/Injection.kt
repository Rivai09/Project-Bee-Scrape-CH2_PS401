package com.dicoding.beescape.di

import android.content.Context
import com.dicoding.beescape.api.retrofit.ApiConfig
import com.dicoding.beescape.data_user.UserPreference
import com.dicoding.beescape.data_user.dataStore
import com.dicoding.beescape.repository.UserRepository

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val tokenFlow = UserPreference.getInstance(context.dataStore)
        val apiService= ApiConfig.getApiService()
        return UserRepository.getInstance(tokenFlow,apiService)
    }
}