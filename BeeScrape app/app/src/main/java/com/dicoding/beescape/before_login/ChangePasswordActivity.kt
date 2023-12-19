package com.dicoding.beescape.before_login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dicoding.beescape.MainActivity
import com.dicoding.beescape.databinding.ActivityChangePasswordBinding
import com.dicoding.beescape.view_model.ResetViewModel
import com.dicoding.beescape.view_model.ViewModelFactory
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding


    private val viewModel by viewModels<ResetViewModel> { ViewModelFactory.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        reset()
    }

    private fun reset() {
        val tokenFlow = viewModel.getSession()
        tokenFlow.observe(this) {
            val token = it.token
            Log.d("reset token", token)

            binding.pwChange.setOnClickListener {
                val pwOld = binding.edPwcurrent.text.toString()
                val pwNew = binding.edPw.text.toString()
                val pwConfirm = binding.edRetypepw.text.toString()
                showLoading(true)

                lifecycleScope.launch {
                    try {
                        showLoading(true)
                        viewModel.reset(token, pwOld, pwNew, pwConfirm)

                        // Jika berhasil reset password
                        showLoading(false)
                        AlertDialog.Builder(this@ChangePasswordActivity).apply {
                            setTitle("Yeah!")
                            setMessage("Akun berhasil diubah password. Silakan login ulang.")
                            setPositiveButton("Lanjut") { _, _ ->
                                viewModel.logout()
                                val intent =
                                    Intent(this@ChangePasswordActivity, SignInActivity::class.java)
                                startActivity(intent)
                            }
                            create()
                            show()
                        }
                    } catch (e: HttpException) {
                        showLoading(false)
                        AlertDialog.Builder(this@ChangePasswordActivity).apply {
                            setTitle("Gagal!")
                            setMessage("Gagal mereset password. ${e.message()}")
                            setPositiveButton("OK") { _, _ ->

                            }
                            create()
                            show()
                        }
                    } catch (e: Exception) {
                        // Jika terjadi kesalahan umum
                        showLoading(false)
                        AlertDialog.Builder(this@ChangePasswordActivity).apply {
                            setTitle("Gagal!")
                            setMessage("Gagal mereset password. Cek koneksi Anda.")
                            setPositiveButton("OK") { _, _ ->
                                // Handle jika diperlukan
                            }
                            create()
                            show()
                        }
                    }
                }


            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        startActivity(Intent(this@ChangePasswordActivity, MainActivity::class.java))
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}