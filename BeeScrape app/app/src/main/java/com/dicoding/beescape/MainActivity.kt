package com.dicoding.beescape

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dicoding.beescape.before_login.WelcomeActivity
import com.dicoding.beescape.ui.theme.BeeScapeTheme
import com.dicoding.beescape.view_model.MainViewModel
import com.dicoding.beescape.view_model.ViewModelFactory

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel> {ViewModelFactory.getInstance(this)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeScapeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BeeScrapeApp()
                }
            }
        }
        cekSession()
    }

    private fun cekSession() {
        mainViewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this,WelcomeActivity::class.java))
            }
        }
    }
}

