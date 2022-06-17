package dev.faith.worklog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.faith.worklog.databinding.ActivityLoginBinding
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
    }
    fun castView() {
        binding.btnlogin.setOnClickListener {
            validatelogin()
            startActivity(Intent(this, HomeActivity::class.java))
        }
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
    }
}


