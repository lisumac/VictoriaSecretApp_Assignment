package com.assignment.victoriassecret.view.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.assignment.victoriassecret.view.fragments.ProductListFragment
import com.assignment.victoriassecret.view.fragments.ProfileFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProductListFragment()
            1 -> ProfileFragment()
            else -> ProductListFragment()
        }
    }
}

