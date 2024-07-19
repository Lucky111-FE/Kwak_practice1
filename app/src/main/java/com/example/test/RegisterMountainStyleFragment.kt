package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test.databinding.FragmentRegisterMountainStyleBinding

class RegisterMountainStyleFragment : Fragment() {
    private val binding by lazy{
        FragmentRegisterMountainStyleBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return binding.root
    }
}