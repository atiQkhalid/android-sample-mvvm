package com.example.mvvmapp.network

import com.example.mvvmapp.model.User
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
