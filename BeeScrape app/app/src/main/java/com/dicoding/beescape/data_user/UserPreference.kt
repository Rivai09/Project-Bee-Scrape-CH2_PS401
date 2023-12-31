package com.dicoding.beescape.data_user

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun saveSession(user: DataUser) {
        dataStore.edit { preferences ->
            preferences[EMAIL_KEY] = user.email
//            preferences[USERNAME_KEY]= user.username
            preferences[TOKEN_KEY] = user.token
            preferences[IS_LOGIN_KEY] = true
        }
    }

    fun getSession(): Flow<DataUser> {
        return dataStore.data.map { preferences ->
            DataUser(
                preferences[EMAIL_KEY] ?: "",
//                preferences[USERNAME_KEY] ?:"",
                preferences[TOKEN_KEY] ?: "",
                preferences[IS_LOGIN_KEY] ?: false
            )
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences.remove((TOKEN_KEY))
            preferences.clear()
        }
    }

    fun saveToken(token: String?) {
        runBlocking {
            if (token != null) {
                dataStore.edit { preferences ->
                    preferences[TOKEN_KEY] = token
                    preferences[IS_LOGIN_KEY] = true
                }
            } else {

                Log.e("UserPreference", "Token is null")
            }
        }
    }



    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val EMAIL_KEY = stringPreferencesKey("email")
        private val USERNAME_KEY = stringPreferencesKey("username")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val IS_LOGIN_KEY = booleanPreferencesKey("isLogin")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}