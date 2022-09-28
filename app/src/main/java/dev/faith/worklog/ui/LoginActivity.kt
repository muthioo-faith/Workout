package dev.faith.worklog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.faith.worklog.LoginRequest
import dev.faith.worklog.LoginResponse
import dev.faith.worklog.api.ApiClient
import dev.faith.worklog.api.ApiInterface
import dev.faith.worklog.databinding.ActivityLoginBinding
import dev.faith.worklog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
    }

    override  fun onResume(){
        super.onResume()
        userViewModel.LoginResponseLiveData.observe(this, Observer { loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))
        })

    }
    fun castView() {
        binding.btnlogin.setOnClickListener {
            validatelogin()
            startActivity(Intent(this, HomeActivity::class.java))

        }
        binding.tvsignup.setOnClickListener {
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        userViewModel.errorLiveData.observe(this, Observer{ errorMessage->
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show()

        })
    }
    fun validatelogin() {
        var error = false
        binding.tilEmail.error = null
        binding.tilpassword.error = null
        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        var password = binding.etpassword.text.toString()
        if (password.isBlank()) {
            binding.tilpassword.error = "Password is required"
            error = true
        }
        if (!error){
            var loginRequest=LoginRequest(email,password)
            binding.pbLogin.visibility= View.GONE
        }
    }

    fun saveLoginDetails(LoginResponse:LoginResponse){
        var editor=sharedPrefs.edit()
        editor.putString("ACCESSTOKEN",LoginResponse.accessToken)
        editor.putString("USER_ID",LoginResponse.userId)
        editor.putString("PROFILE_ID", LoginResponse.profileId)
        editor.apply()
    }
}


