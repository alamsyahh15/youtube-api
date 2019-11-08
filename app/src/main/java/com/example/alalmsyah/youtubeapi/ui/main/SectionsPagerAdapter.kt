package com.example.alalmsyah.youtubeapi.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.alalmsyah.youtubeapi.KulinerFragment
import com.example.alalmsyah.youtubeapi.SportsFragment
import com.example.alalmsyah.youtubeapi.TravelerFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        var fragment = Fragment()
        when (position){
            0 -> fragment = SportsFragment()
            1 -> fragment = TravelerFragment()
            2 -> fragment = KulinerFragment()

        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var nameTabs = ""
        when(position) {
            0 -> nameTabs = "Sports"
            1 -> nameTabs = "Traveler"
            2 -> nameTabs = "Kuliner"
        }
        return  nameTabs
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}