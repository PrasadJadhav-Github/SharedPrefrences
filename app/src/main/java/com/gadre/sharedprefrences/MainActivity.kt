package com.gadre.sharedprefrences

import User
import UserManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gadre.sharedprefrences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        checkLoginStatus()
        onLoginButtonClick()


    }

    private fun checkLoginStatus() {
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        val mobilenumber = sharedPreferences.getString("mobilenumber", null)
        val isChecked = sharedPreferences.getBoolean("checkbox_value", false)


        if (username != null && password != null && mobilenumber != null) {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }


        binding.checkbox.isChecked = isChecked
    }

    private fun onLoginButtonClick() {
        binding.Buttonlogin.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            val mobilenumber = binding.mobilenumber.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {

                val save = sharedPreferences.edit()
                save.putString("username", username)
                save.putString("password", password)
                save.putString("mobilenumber", mobilenumber)
                save.putBoolean("checkbox_value", binding.checkbox.isChecked)
                save.apply()

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Start MainActivity2
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
