package com.example.test.ViewPageAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test.RegisterExtraInfoFragment
import com.example.test.RegisterFinishFragment
import com.example.test.RegisterMountainStyleFragment
import com.example.test.RegisterProfileFragment
import com.example.test.RegisterStartFragment

// 3개의 화면을 구성한다고 가정
// OneFragment, TwoFragment, ThreeFragment
class ViewPageAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    // 페이지 갯수 설정
    override fun getItemCount(): Int = 4

    // 불러올 Fragment 정의
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RegisterExtraInfoFragment()
            1 -> RegisterProfileFragment()
            2 -> RegisterMountainStyleFragment()
            3 -> RegisterFinishFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }
}