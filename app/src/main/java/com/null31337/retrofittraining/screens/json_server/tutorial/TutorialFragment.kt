package com.null31337.retrofittraining.screens.json_server.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.null31337.retrofittraining.databinding.TutorialMainFragmentBinding

class TutorialFragment : Fragment() {
    private lateinit var binding: TutorialMainFragmentBinding
    private lateinit var adapter: TutorialPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TutorialMainFragmentBinding.inflate(layoutInflater, container, false)
        adapter = TutorialPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        binding.viewPagerTutorial.adapter = adapter
        return binding.root
    }
}