package dev.faith.worklog.api

import dev.faith.worklog.LoginRequest
import dev.faith.worklog.LoginResponse
import dev.faith.worklog.models.RegisterResponse
import dev.faith.worklog.models.ReqisterRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest:ReqisterRequest):Response<RegisterResponse>

    @POST("/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}