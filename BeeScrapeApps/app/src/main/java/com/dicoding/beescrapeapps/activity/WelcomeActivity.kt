package com.dicoding.beescrapeapps.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.beescrapeapps.R
import com.dicoding.beescrapeapps.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()

        supportActionBar?.hide()

        binding.signUpEmail.setOnClickListener{
            startActivity(Intent(this@WelcomeActivity,SignUpEmailActivity::class.java))
        }
        binding.login.setOnClickListener{
            startActivity(Intent(this@WelcomeActivity,LoginActivity::class.java))
        }


    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupView(){
//        binding.AlreadyHaveAccount.text = Html.fromHtml(getString(R.string.already_have_an_account))
        binding.login.text=Html.fromHtml(getString(R.string.login))

        val drawable = getDrawable(R.drawable.logo_fb)
        drawable?.setBounds(0,0,55,55)
        binding.signUpFb.setCompoundDrawables(drawable,null,null,null)

        val drawable2 = getDrawable(R.drawable.logo_google)
        drawable2?.setBounds(0,0,60,60)
        binding.signUpGoogle.setCompoundDrawables(drawable2,null,null,null)
    }

}