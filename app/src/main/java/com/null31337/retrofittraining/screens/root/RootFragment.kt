package com.null31337.retrofittraining.screens.root

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.ViewPagerAdapter

class RootFragment : Fragment() {

    private var ctx: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)
        view.findViewById<TabLayout>(R.id.tabLayout).tabIconTint = null
        view.findViewById<ViewPager2>(R.id.view_pager_root).adapter =
            ViewPagerAdapter(ctx as FragmentActivity)
        TabLayoutMediator(
            view.findViewById(R.id.tabLayout),
            view.findViewById(R.id.view_pager_root)
        ) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.setIcon(R.drawable.ic_baseline_attach_money_24)
                }
                1 -> {
                    tab.setIcon(R.drawable.matrix)
                }
                2 -> {
                    tab.setIcon(R.drawable.cat)
                }
            }
        }.attach()
        return view
    }
}