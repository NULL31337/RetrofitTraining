package com.null31337.retrofittraining.screens.json_server.tutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.null31337.retrofittraining.screens.json_server.tutorial.steps.FirstStepFragment
import com.null31337.retrofittraining.screens.json_server.tutorial.steps.SecondStepFragment
import com.null31337.retrofittraining.screens.json_server.tutorial.steps.ThirdStepFragment

class TutorialPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> FirstStepFragment()
        1 -> SecondStepFragment()
        else -> ThirdStepFragment()
    }
}