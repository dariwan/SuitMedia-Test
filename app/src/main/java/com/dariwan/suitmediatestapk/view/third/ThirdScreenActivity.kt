package com.dariwan.suitmediatestapk.view.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.suitmediatestapk.R
import com.dariwan.suitmediatestapk.adapter.AllUsersAdapter
import com.dariwan.suitmediatestapk.databinding.ActivityThirdScreenBinding

class ThirdScreenActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdScreenBinding
    private val viewModel: ThirdScreenViewModel by viewModels {
        ThirdScreenViewModel.FoodMaterialFactory(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        val adapter = AllUsersAdapter()
        binding.rvUser.adapter = adapter
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        viewModel.material.observe(this){
            adapter.submitData(lifecycle, it)
        }
    }
}