package dev.faith.worklog.repository

import dev.faith.worklog.LoginRequest
import dev.faith.worklog.LoginResponse
import dev.faith.worklog.api.ApiClient
import dev.faith.worklog.api.ApiInterface
import dev.faith.worklog.models.ReqisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>
    = withContext(Dispatchers.IO){
        val response=apiClient.loginUser(loginRequest)
        return@withContext response

    }
    suspend fun makeUserRequest(registerRequest: ReqisterRequest)
            = withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequest)
        return@withContext response
    }
}