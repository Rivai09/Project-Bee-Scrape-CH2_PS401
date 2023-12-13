package com.dicoding.beescape.before_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.dicoding.beescape.R
import com.dicoding.beescape.databinding.ActivitySignUpBinding
import com.dicoding.beescape.view_model.RegisterViewModel
import com.dicoding.beescape.view_model.ViewModelFactory
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val registerViewModel by viewModels<RegisterViewModel> { ViewModelFactory.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        register()
    }

    private fun register() {
        binding.signUpEmailButton.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val name = binding.edUsername.text.toString()
            val pw = binding.edPw.text.toString()
//            showLoading(true)

            lifecycleScope.launch {
                registerViewModel.registerUser(name, email, pw)
                try {
//                    showLoading(false)
                    val message = registerViewModel.successMessage
                    if (message != null) {
                        AlertDialog.Builder(this@SignUpActivity).apply {
                            setTitle("Yeah!")
                            setMessage("Akun dengan $email berhasil dibuat. Yuk, login.")
                            setPositiveButton("Lanjut") { _, _ ->
                                val intent =
                                    Intent(this@SignUpActivity, SignInActivity::class.java)
                                startActivity(intent)
                            }
                            create()
                            show()
                        }

                    } else {
//                        showLoading(false)
                        AlertDialog.Builder(this@SignUpActivity).apply {
                            setTitle("Gagal!")
                            setMessage("Pendaftaran gagal. Pastikan email, nama, dan password valid atau akun sudah terdaftar")
                            setPositiveButton("OK") { _, _ ->
                            }
                            create()
                            show()
                        }
                    }
//                    showLoading(false)
                } catch (e: Exception) {
                    AlertDialog.Builder(this@SignUpActivity).apply {
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