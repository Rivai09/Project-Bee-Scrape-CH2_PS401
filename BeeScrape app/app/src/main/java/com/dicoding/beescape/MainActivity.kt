package com.dicoding.beescape

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
                    if (isNetworkAvailable()){
                        BeeScrapeApp()
                    }else{
                        AlertDialog.Builder(this).apply {
                            setTitle("No Internet Connection")
                            setMessage("enable internet connectivity to continue.")
                            setPositiveButton("Enable Internet") { _, _ ->
                                startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                            }
                            setNegativeButton("Cancel") { _, _ ->
                                showToast("Please enable internet to use the app.")
                                finish()
                            }
                            create()
                            show()
                        }
                    }

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

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

