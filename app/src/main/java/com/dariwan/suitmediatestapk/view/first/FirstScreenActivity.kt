package com.dariwan.suitmediatestapk.view.first

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.suitmediatestapk.R
import com.dariwan.suitmediatestapk.databinding.ActivityMainBinding
import com.dariwan.suitmediatestapk.view.second.SecondScreenActivity

class FirstScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupPalindrome() {
        val palindrome = binding.edPolindrome.text.toString()
        if (palindrome == palindrome.reversed()){
            val dialogBinding = layoutInflater.inflate(R.layout.custom_dialog_palindrome, null)
            val dialog = Dialog(this)
            dialog.setContentView(dialogBinding)
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            dialog.show()
        }else {
            val dialogBinding = layoutInflater.inflate(R.layout.custom_dialog_not_palindrome, null)
            val dialog = Dialog(this)
            dialog.setContentView(dialogBinding)
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            dialog.show()
        }

    }

    private fun sendName(){
        val name = binding.edName.text.toString()
        val sendDataName = Intent(this@FirstScreenActivity, SecondScreenActivity::class.java)
        sendDataName.putExtra(SecondScreenActivity.EXTRA_NAME, name)
        startActivity(sendDataName)
    }

    private fun setupView() {
        binding.btnCheck.setOnClickListener {
            setupPalindrome()
        }
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, SecondScreenActivity::class.java)
            startActivity(intent)
            sendName()
        }
    }
}