package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentShowPostsBinding
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel


open class ShowPostsFragment :
    Fragment() {
    private val args: ShowPostsFragmentArgs by navArgs()
    private lateinit var binding: FragmentShowPostsBinding
    private lateinit var recyclerView: RecyclerView
    protected lateinit var adapter: ShowPostsAdapter
    protected lateinit var viewModel: FunctionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    APP.navController.navigateUp()
                    APP.navController.navigateUp()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        binding = FragmentShowPostsBinding.inflate(layoutInflater, container, false)

        recyclerView = binding.functionsBtn
        adapter = ShowPostsAdapter()
        recyclerView.adapter = adapter
        args.posts?.let {
            adapter.setList(it.toList())
        }
        return binding.root
    }
}