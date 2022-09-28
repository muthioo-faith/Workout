package dev.faith.worklog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.faith.worklog.LoginRequest
import dev.faith.worklog.LoginResponse
import dev.faith.worklog.models.RegisterResponse
import dev.faith.worklog.models.ReqisterRequest
import dev.faith.worklog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository = UserRepository()
    val LoginResponseLiveData = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    val registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val  registerErrorLiveData=MutableLiveData<String?>()

    fun logninUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful) {
                LoginResponseLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun registerUser(registerRequest:ReqisterRequest){
        viewModelScope.launch {
            val response=UserRepository.makeUserRequest(registerRequest)
            if (response.isSuccessful){
                registerResponseLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
        }
    }
