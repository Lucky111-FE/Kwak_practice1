package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.databinding.FragmentRegisterStartBinding

class RegisterStartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentRegisterStartBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_view, ViewPagerFragment()).addToBackStack(null).commit()
        }

        return binding.root
    }
}