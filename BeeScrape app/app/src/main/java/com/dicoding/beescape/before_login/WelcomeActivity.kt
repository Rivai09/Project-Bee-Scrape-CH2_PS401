package com.dicoding.beescape.before_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.beescape.R
import com.dicoding.beescape.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpEmail.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity,SignUpActivity::class.java))
        }
        binding.login.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity,SignInActivity::class.java))
        }

    }
}