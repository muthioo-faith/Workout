package dev.faith.worklog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var btnlogin: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilpassword: TextInputLayout
    lateinit var etpassword: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin = findViewById(R.id.btnlogin)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tilpassword = findViewById(R.id.tilpassword)
        etpassword = findViewById(R.id.etpassword)
        btnlogin.setOnClickListener { validatelogin() }

    }

    fun validatelogin() {
        var error = false
        tilEmail.error=null
        tilpassword.error=null
        var email = etEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
            error = true
        }
        var password = etpassword.text.toString()
        if (password.isBlank()) {
            tilpassword.error = "Password is required"
            error = true
        }
        if (error != true) {
        }
    }
}