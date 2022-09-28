package dev.faith.worklog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.faith.worklog.R
import dev.faith.worklog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharePrefs:SharedPreferences
    lateinit var tvLogout:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvLogout=findViewById(R.id.tvLogout)
        tvLogout. setOnClickListener{
            val editor=sharePrefs.edit()
            editor.putString("ACCESS_TOKEN","")
            editor.putString("USER_ID","")
            editor.putString("PROFILE_ID","")
            editor.apply()
            startActivity(Intent(this,LoginActivity::class.java))
            logoutRequest()


        }

        castViews()
        setUpBottomNav()
    }
    fun castViews(){
//        binding.bnvHome=findViewById(R.id.bottom_navigation)
//       binding. fcvHome=findViewById(R.id.fcvHome)
    }
    fun setUpBottomNav(){
       binding.bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.plan -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, planFragment()).commit()
                    true
                }
                R.id.track -> {
                    val transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }
        }
    fun logoutRequest(){
        sharePrefs.edit().clear().commit()

    }
}


