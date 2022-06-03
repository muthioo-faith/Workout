package dev.faith.worklog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var tilfirstname:TextInputLayout
    lateinit var etfirstname:TextInputEditText
    lateinit var tillastname:TextInputLayout
    lateinit var etlastname:TextInputEditText
    lateinit var tilemail:TextInputLayout
    lateinit var etemail:TextInputEditText
    lateinit var tilpassword1:TextInputLayout
    lateinit var etpassword1:TextInputEditText
    lateinit var tilconfirmpassword:TextInputLayout
    lateinit var etconfirmpassword:TextInputEditText
    lateinit var tvlogin:TextView
    lateinit var btnsignup:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tvlogin=findViewById(R.id.tvlogin)
        etfirstname=findViewById(R.id.etfirstname)
        tilfirstname=findViewById(R.id.tilfirstname)
        etlastname=findViewById(R.id.etlastname)
        tillastname=findViewById(R.id.tillastname)
        etemail=findViewById(R.id.etemail)
        tilemail=findViewById(R.id.tilEmail)
        etpassword1=findViewById(R.id.etpassword1)
        tilpassword1=findViewById(R.id.tilpassword1)
        etconfirmpassword=findViewById(R.id.etconfirmpassword)
        tilconfirmpassword=findViewById(R.id.tilconfirmpassword)
        btnsignup=findViewById(R.id.btnsign)

        tvlogin.setOnClickListener{
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        btnsignup.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            validatesignup()
        }

    }
    fun validatesignup(){
        var firstname=etfirstname.text.toString()
        var lastname=etlastname.text.toString()
        var email=etemail.text.toString()
        var password=etpassword1.text.toString()
        var confirmpassword=etconfirmpassword.text.toString()

        if (firstname.isBlank()){
            tilfirstname.error="First name is required"
        }
        if (lastname.isBlank()){
            tillastname.error="Last name is required"
        }
        if (email.isBlank()){
            tilemail.error="Email is required"
        }
        if (password.isBlank()){
            tilpassword1.error="Password is required"
        }
        if (confirmpassword.isBlank()){
            tilconfirmpassword.error="Confirm your password"
        }
    }
}