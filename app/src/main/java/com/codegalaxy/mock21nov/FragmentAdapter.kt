package com.codegalaxy.mock21nov

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codegalaxy.mock21nov.view.Fragment1
import com.codegalaxy.mock21nov.view.Fragment2
import com.codegalaxy.mock21nov.view.FragmentActivity

class FragmentAdapter(activity: FragmentActivity):FragmentStateAdapter(activity) {

    private val fragment1= Fragment1()
    private val fragment2= Fragment2()

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> fragment1
            1 -> fragment2
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

//    //function to set data in Fragment2
//    fun setFragment2Data(data: String) {
//        fragment2.setData(data)
//    }
}