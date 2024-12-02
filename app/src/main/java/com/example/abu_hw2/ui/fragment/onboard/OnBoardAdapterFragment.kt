package com.example.abu_hw2.ui.fragment.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardAdapterFragment (fragment: Fragment
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int) = OnBoardViewPagerFragment().apply{
        arguments = Bundle().apply{
            putInt(OnBoardViewPagerFragment.ARG_ONBOARD_POSITION, position)
        }
    }
}