package com.codegalaxy.mock21nov.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import com.codegalaxy.mock21nov.R
import com.codegalaxy.mock21nov.databinding.Fragment2Binding
import com.codegalaxy.mock21nov.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Fragment2 : Fragment() {

   private lateinit var binding: Fragment2Binding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.sharedData.observe(viewLifecycleOwner){data->
            if(binding.edtDisplay.text.toString() !=data){
                binding.edtDisplay.setText(data)
            }
        }

        binding.edtDisplay.addTextChangedListener {
            val inputEditText=it.toString()

            if(inputEditText!=sharedViewModel.sharedData.value)
            {
                sharedViewModel.setSharedData(inputEditText)
            }

        }

//        binding.edtDisplay.addTextChangedListener {
//            sharedViewModel.setSharedData(it.toString())
//        }

    }

//    fun setData(inputText: String) {
//        binding.edtDisplay.setText(inputText)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.edtDisplay.setText("")
    }
}