package com.dicoding.beescape.api.retrofit

import com.dicoding.beescape.api.response.DataResponse
import com.dicoding.beescape.api.response.LoginResponse
import com.dicoding.beescape.api.response.Product
import com.dicoding.beescape.api.response.ResetResponse
import com.dicoding.beescape.api.response.SignUpResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

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
        @Header("Authorization") token: String,
        @Field("passowrdLama") passwordLama: String,
        @Field("passwordBaru") passwordBarul: String,
        @Field("passwordKonfirmasi") passwordKonfirmasi: String,
    ): ResetResponse

//    @GET("productList")
//    suspend fun getDataPaging(
//        @Header("Authorization") token: String,
//        @Query("page") page: Int? = 1,
//        @Query("size") size: Int? = 20,
//    ): MainResponse


//    @GET("productList")
//    suspend fun getData(@Header("Authorization") token: String): MainResponse

    @GET("productList")
    suspend fun getData(@Header("Authorization") token: String): DataResponse

    @GET("productList/{id}")
    suspend fun getDetail(
        @Header("Authorization") token: String,
        @Path("id") id: String,
    ): Product

//    @GET("productList")
//    suspend fun searchData(@Query("query") query: String): Response<List<ItemsItem>>
}
