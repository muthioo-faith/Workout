package dev.faith.worklog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dev.faith.worklog.LoginResponse
import dev.faith.worklog.api.ApiClient
import dev.faith.worklog.api.ApiInterface
import dev.faith.worklog.databinding.ActivitySignUpBinding
import dev.faith.worklog.models.RegisterResponse
import dev.faith.worklog.models.ReqisterRequest
import dev.faith.worklog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(
            this,
            {registerResponse->
                Toast.makeText(baseContext,registerResponse.message,Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext,LoginActivity::class.java))
            })
        userViewModel.registerErrorLiveData.observe(
            this,
            androidx.lifecycle.Observer { registerError ->
                Toast.makeText(baseContext, registerError, Toast.LENGTH_LONG).show()
            })
    }



    fun castView() {
        binding.tvlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


    fun validatesignup() {
        var firstname = binding.etfirstname.text.toString()
        var lastname = binding.etlastname.text.toString()
        var email = binding.etemail.text.toString()
        var password = binding.etpassword1.text.toString()
        var confirmpassword = binding.etconfirmpassword.text.toString()
        var error = false

        if (firstname.isBlank()) {
            binding.tilfirstname.error = "First name is required"
        }
        if (lastname.isBlank()) {
            binding.tillastname.error = "Last name is required"
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
        }
        if (password.isBlank()) {
            binding.tilpassword1.error = "Password is required"
        }
        if (confirmpassword.isBlank()) {
            binding.tilconfirmpassword.error = "Confirm your password"
        }
        if (password != confirmpassword) {
            binding.tilconfirmpassword.error = "Wrong password"
        }
        if (!error) {
            var registerRequest = ReqisterRequest(firstname, lastname, email, password)
            userViewModel.registerUser(registerRequest)

//            makeRegisterRequest(registerRequest)
//            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    fun makeRegisterRequest(registerRequest: ReqisterRequest) {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.registerUser(registerRequest)

    }
}
