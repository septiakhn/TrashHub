package com.neisha.trashhub.view.login

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.neisha.trashhub.databinding.ActivityLoginBinding
import com.neisha.trashhub.view.main.MainActivity
import com.neisha.trashhub.view.mitra.MitraActivity
import com.neisha.trashhub.view.splash.SecondActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            when (validateCredentials(email, password)) {
                Role.USER -> {
                    Toast.makeText(this, "Login successful as User", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }
                Role.MITRA -> {
                    Toast.makeText(this, "Login successful as Mitra", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MitraActivity::class.java))
                }
                else -> {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.registerTextView.setOnClickListener {
            // Navigate to the Register activity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateCredentials(email: String, password: String): Role? {
        // Mock validation for user and mitra
        val userMockEmail = "user@example.com"
        val userMockPassword = "userpassword"
        val mitraMockEmail = "mitra@example.com"
        val mitraMockPassword = "mitrapassword"

        return when {
            email == userMockEmail && password == userMockPassword -> Role.USER
            email == mitraMockEmail && password == mitraMockPassword -> Role.MITRA
            else -> null
        }
    }

    enum class Role {
        USER, MITRA
    }
}
