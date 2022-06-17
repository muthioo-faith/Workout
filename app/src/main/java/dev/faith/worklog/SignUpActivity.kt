package dev.faith.worklog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.faith.worklog.databinding.ActivityLoginBinding
import dev.faith.worklog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
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
        var password =binding. etpassword1.text.toString()
        var confirmpassword =binding. etconfirmpassword.text.toString()

        if (firstname.isBlank()) {
          binding.  tilfirstname.error = "First name is required"
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
    }
}