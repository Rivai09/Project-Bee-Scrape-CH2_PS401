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
                    viewModel.reset(token,pwOld,pwNew,pwConfirm)
                    try {
                        val message = viewModel.successMessage
                        if (message != null) {
                            showLoading(false)
                            AlertDialog.Builder(this@ChangePasswordActivity).apply {
                                setTitle("Yeah!")
                                setMessage("password berhasil diganti")
                                setPositiveButton("Lanjut") { _, _ ->
                                    val intent = Intent(
                                        this@ChangePasswordActivity,
                                        SignInActivity::class.java
                                    )
                                    startActivity(intent)
                                }
                                create()
                                show()
                            }

                        } else {
                            showLoading(false)
                            AlertDialog.Builder(this@ChangePasswordActivity).apply {
                                setTitle("Gagal!")
                                setMessage("cek lagi")
                                setPositiveButton("OK") { _, _ ->
                                }
                                create()
                                show()
                            }
                        }
                    } catch (e: Exception) {
                        showLoading(false)
                        AlertDialog.Builder(this@ChangePasswordActivity).apply {
                            setTitle("Gagal!")
                            setMessage("Pendaftaran gagal. $e")
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


    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        startActivity(Intent(this@ChangePasswordActivity, MainActivity::class.java))
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}