package com.null31337.retrofittraining.screens.json_server.functions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.databinding.FunctionsFragmentBinding


class FunctionsFragment : Fragment() {
    private lateinit var binding: FunctionsFragmentBinding
    lateinit var viewModel: FunctionsViewModel
    lateinit var adapter: FunctionsAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        binding = FunctionsFragmentBinding.inflate(layoutInflater, container, false)

        recyclerView = binding.functionsBtn
        adapter = FunctionsAdapter()
        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
    }
}