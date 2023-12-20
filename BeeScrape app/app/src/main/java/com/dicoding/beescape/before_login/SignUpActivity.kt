package com.dicoding.beescape.before_login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
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
            showLoading(true)
            val emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"

            lifecycleScope.launch {

                if (pw.length>=8 && email.matches(emailPattern.toRegex())){
                    registerViewModel.registerUser(name, email, pw)
                    showLoading(false)
                    val message = registerViewModel.successMessage
                    if (message != null ) {
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

                    }

                }else {
                    showLoading(false)
                    AlertDialog.Builder(this@SignUpActivity).apply {
                        setTitle("Gagal!")
                        setMessage("Pendaftaran gagal. Pastikan email, nama, dan password valid (password minimal 8 character dan format email yang sesuai atau akun sudah terdaftar")
                        setPositiveButton("OK") { _, _ ->
                        }
                        create()
                        show()
                    }
                }
                try {

                    showLoading(false)
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

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}