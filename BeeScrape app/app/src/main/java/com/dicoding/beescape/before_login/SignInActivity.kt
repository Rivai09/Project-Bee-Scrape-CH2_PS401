package com.dicoding.beescape.before_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.dicoding.beescape.MainActivity
import com.dicoding.beescape.R
import com.dicoding.beescape.databinding.ActivitySignInBinding
import com.dicoding.beescape.view_model.LoginViewModel
import com.dicoding.beescape.view_model.ViewModelFactory
import kotlinx.coroutines.launch

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val viewModel by viewModels<LoginViewModel> {ViewModelFactory.getInstance(this)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
    }


    private fun login() {
        binding.loginBtn.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val pw = binding.edPw.text.toString()

//            showLoading(true)

            lifecycleScope.launch {
                viewModel.login(email, pw)
                try {
                    val message = viewModel.successMessage
                    if (message != null) {
//                        showLoading(false)
                        AlertDialog.Builder(this@SignInActivity).apply {
                            setTitle("Yeah!")
                            setMessage("validasi akun berhasil, anda akan ke halaman utama")
                            setPositiveButton("Lanjut") { _, _ ->
                                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                                startActivity(intent)
                            }
                            create()
                            show()
                        }

                    } else {
//                        showLoading(false)
                        AlertDialog.Builder(this@SignInActivity).apply {
                            setTitle("Gagal!")
                            setMessage("Pastikan email, nama, dan password valid atau akun belum terdaftar")
                            setPositiveButton("OK") { _, _ ->
                            }
                            create()
                            show()
                        }
                    }
                } catch (e: Exception) {
//                    showLoading(false)
                    AlertDialog.Builder(this@SignInActivity).apply {
                        setTitle("Gagal!")
                        setMessage("Pendaftaran gagal. Pastikan email, nama, dan password valid atau cek koneksi anda")
                        setPositiveButton("OK") { _, _ ->
                        }
                        create()
                        show()
                    }
                }
            }
        }
    }
}