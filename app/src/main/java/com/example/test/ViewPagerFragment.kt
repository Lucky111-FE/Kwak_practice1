package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.ViewPageAdapter.ViewPageAdapter
import com.example.test.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentViewPagerBinding.inflate(layoutInflater)
        val adapter = ViewPageAdapter(requireActivity())
        binding.viewPager.adapter =  adapter

        binding.springDotsIndicator.attachTo(binding.viewPager)
        return binding.root
    }

}