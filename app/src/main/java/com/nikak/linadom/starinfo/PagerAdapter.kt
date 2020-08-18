package com.nikak.linadom.starinfo

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fm: FragmentActivity, private var tabCount: Int) : FragmentStateAdapter(fm) {


    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> {
                Log.i("!!!here", "here")
                PlanetsFragment()

            }
            else -> PlanetsFragment()
        }
    }
}