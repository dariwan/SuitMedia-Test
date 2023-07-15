package com.dariwan.suitmediatestapk.view.second

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.suitmediatestapk.R
import com.dariwan.suitmediatestapk.databinding.ActivitySecondScreenBinding
import com.dariwan.suitmediatestapk.view.third.ThirdScreenActivity

class SecondScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupView()
    }

    private fun setupView() {
        binding.btnChoseUser.setOnClickListener {
            val intent = Intent(this, ThirdScreenActivity::class.java)
            startActivity(intent)
        }

        getDataName()
    }

    fun getDataName(){
        val name = intent.getStringExtra(EXTRA_NAME)
        val text = name
        binding.tvName.text = text
    }

    companion object{
        const val EXTRA_NAME = "extra_name"
    }
}