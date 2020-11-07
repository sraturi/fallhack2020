package com.example.fallhack2020

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fallhack2020.fragments.HomeFragment
import com.example.fallhack2020.fragments.MyInventoryFragment
import com.example.fallhack2020.fragments.MyProfileFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int {
    return TABS.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            1 -> HomeFragment()
            2 -> MyInventoryFragment()
            3 -> MyProfileFragment()
            else -> HomeFragment()
        }
    }

    companion object {
        val TABS = arrayOf("Home","Inventory","Profile")
    }
}