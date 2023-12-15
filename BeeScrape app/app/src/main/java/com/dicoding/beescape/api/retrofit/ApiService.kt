package com.dicoding.beescape.api.retrofit

import com.dicoding.beescape.api.response.LoginResponse
import com.dicoding.beescape.api.response.ResetResponse
import com.dicoding.beescape.api.response.SignUpResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("signup")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): SignUpResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @FormUrlEncoded
    @POST("password-reset")
    suspend fun resetPassword(
        @Field("passowrdLama") name: String,
        @Field("passwordBaru") email: String,
        @Field("passwordKonfirmasi") password: String
    ): ResetResponse
}
