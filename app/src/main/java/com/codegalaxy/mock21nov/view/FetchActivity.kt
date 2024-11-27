package com.codegalaxy.mock21nov.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.codegalaxy.mock21nov.NetworkUtils
import com.codegalaxy.mock21nov.ProductAdapter
import com.codegalaxy.mock21nov.UiState
import com.codegalaxy.mock21nov.databinding.ActivityFetchBinding
import com.codegalaxy.mock21nov.viewmodel.FetchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FetchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFetchBinding
    private val viewModel: FetchViewModel by viewModels()
    private val adapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFetchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

//        if (NetworkUtils.isInternetAvailable(this)) {
//            viewModel.fetchProducts(listOf("ff808181932badb6019351cd3a446200", "ff808181932badb6019351ceb8276203", "ff808181932badb6019351d40c84621e"))
//        } else {
//            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
//        }

        viewModel.fetchProducts(listOf("ff808181932badb6019351cd3a446200", "ff808181932badb6019351ceb8276203", "ff808181932badb6019351d40c84621e"))


        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun observeViewModel() {

        viewModel.uiState.observe(this) { state ->
            when (state) {

                is UiState.Loading -> binding.loader.visibility = View.VISIBLE

                is UiState.Success -> {
                    binding.loader.visibility = View.GONE
                    adapter.submitList(state.data)
                }

                is UiState.Error -> {
                    binding.loader.visibility = View.GONE
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
