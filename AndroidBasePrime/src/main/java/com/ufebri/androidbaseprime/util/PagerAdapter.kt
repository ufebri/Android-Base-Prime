package com.ufebri.androidbaseprime.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by Uray Febri on 07/03/2022.
 */
class PagerAdapter(
    fragmentManager: FragmentManager,
    private val titles: List<CharSequence>,
    private val content: List<Fragment>
) : FragmentStatePagerAdapter(fragmentManager) {

    private val numOfTabs: Int = titles.size

    private val PAGE1 = 0
    private val PAGE2 = 1
    private val PAGE3 = 2

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment = when (position) {
            PAGE1 -> content[0]
            PAGE2 -> content[1]
            PAGE3 -> content[2]
            else -> content[3]
        }
        return fragment
    }

    override fun getCount(): Int {
        return numOfTabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}