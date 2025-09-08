package com.example.mvvmapp.repository

import com.example.mvvmapp.model.User
import com.example.mvvmapp.network.UserService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(private val api: UserService) {
    fun fetchUsers(): Flow<List<User>> = flow {
        val users = api.getUsers()
        emit(users)
    }
}
