package com.nikak.linadom.starinfo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class TabActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        var tabLayout = findViewById<TabLayout>(R.id.tabBar)
        var planetsTab = findViewById<TabItem>(R.id.PlanetsTab)
        var statisticsTab = findViewById<TabItem>(R.id.StatisticsTab)
        var viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        print("tabcount ${tabLayout.tabCount}")
        var pagerAdapter = PagerAdapter(this, tabLayout.tabCount)
        viewPager2.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Planets"
                }
                1 -> tab.text = "Statistics"
            }
            Log.i("!!!position = ", tab.position.toString())
        }.attach()

        val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.i("!!!position = ", tab.position.toString())
                viewPager2.currentItem = tab.position
//                var createdFragment = pagerAdapter.createFragment(viewPager2.currentItem)
//                var fragmentManager:FragmentManager = supportFragmentManager
//                var fragmentTransaction = fragmentManager.beginTransaction()
//                fragmentTransaction.add(R.id.viewPager2, createdFragment)
//                fragmentTransaction.commit()


            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {
////
            }
        }



        tabLayout.addOnTabSelectedListener(onTabSelectedListener)


        // Example of a call to a native method
//        sample_text.text = stringFromJNI()
    }

        /**
         * A native method that is implemented by the 'native-lib' native library,
         * which is packaged with this application.
         */
        external fun stringFromJNI(): String

        companion object {

            // Used to load the 'native-lib' library on application startup.
            init {
                System.loadLibrary("native-lib")
            }
        }
    }
