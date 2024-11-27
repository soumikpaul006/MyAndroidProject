package com.codegalaxy.mock21nov.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import com.codegalaxy.mock21nov.R
import com.codegalaxy.mock21nov.databinding.Fragment1Binding
import com.codegalaxy.mock21nov.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.sharedData.observe(viewLifecycleOwner) { data ->
            if(binding.editTextInput.text.toString()!=data) {
                binding.editTextInput.setText(data)
            }
        }


        binding.editTextInput.addTextChangedListener {
            val inputText = it.toString()
            viewModel.setSharedData(inputText)
            if(inputText!=viewModel.sharedData.value)
            {
                viewModel.setSharedData(inputText)
            }
        }



//        binding.submitButton.setOnClickListener{
//            val inputText = binding.editTextInput.text.toString()
//
//            viewModel.setSharedData(inputText)
//
//            val activity = requireActivity() as FragmentActivity
////            activity.navigateToFragment2(inputText)
//            activity.binding.viewPager.currentItem=1
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.editTextInput.text.clear()
    }

}