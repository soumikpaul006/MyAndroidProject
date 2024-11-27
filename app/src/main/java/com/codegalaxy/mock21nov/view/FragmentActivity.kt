package com.codegalaxy.mock21nov.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codegalaxy.mock21nov.FragmentAdapter
import com.codegalaxy.mock21nov.R
import com.codegalaxy.mock21nov.databinding.ActivityFragmentBinding
import com.codegalaxy.mock21nov.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentBinding
    private lateinit var adapter: FragmentAdapter
    private val sharedViewModel:SharedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedViewModel.sharedData.observe(this) {data->
            binding.textView.text=data
        }

        adapter = FragmentAdapter(this)
        binding.viewPager.adapter = adapter

    }

//    //navigate to fragment 2
//    fun navigateToFragment2(inputText: String)  {
//        adapter.setFragment2Data(inputText)
//        binding.viewPager.currentItem = 1
//    }

}