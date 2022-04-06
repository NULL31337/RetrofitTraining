package com.null31337.retrofittraining.screens.root

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.null31337.retrofittraining.screens.cat.CatFragment
import com.null31337.retrofittraining.screens.json_server.menu.MenuFragment
import com.null31337.retrofittraining.screens.matrix.MatrixFragment
import com.null31337.retrofittraining.screens.money.MoneyFragment
import com.null31337.retrofittraining.screens.note.list.NoteListFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = 5


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            3 -> MoneyFragment()
            1 -> MatrixFragment()
            2 -> NoteListFragment()
            0 -> MenuFragment()
            else -> CatFragment()
        }
    }
}