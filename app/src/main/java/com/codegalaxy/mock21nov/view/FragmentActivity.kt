package com.codegalaxy.mock21nov.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codegalaxy.mock21nov.FragmentAdapter
import com.codegalaxy.mock21nov.R
import com.codegalaxy.mock21nov.databinding.ActivityFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentBinding
    private lateinit var adapter: FragmentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FragmentAdapter(this)
        binding.viewPager.adapter = adapter

    }

//    //navigate to fragment 2
//    fun navigateToFragment2(inputText: String)  {
//        adapter.setFragment2Data(inputText)
//        binding.viewPager.currentItem = 1
//    }

}