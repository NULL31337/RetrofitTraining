package com.null31337.retrofittraining

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.null31337.retrofittraining.screens.cat.CatFragment
import com.null31337.retrofittraining.screens.money.MoneyFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MoneyFragment()
            else -> CatFragment()
        }
    }
}