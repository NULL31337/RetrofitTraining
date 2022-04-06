package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentShowPostsBinding
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo

abstract class ShowPostsFragment :
    Fragment() {
    lateinit var binding: FragmentShowPostsBinding
    lateinit var recyclerView: RecyclerView
    protected lateinit var adapter: ShowPostsAdapter
    protected lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        binding = FragmentShowPostsBinding.inflate(layoutInflater, container, false)

        recyclerView = binding.functionsBtn
        adapter = ShowPostsAdapter()
        recyclerView.adapter = adapter
        return binding.root
    }

    companion object {
        val buttonInfo =
            ButtonInfo("Show posts", R.id.action_functionsFragment_to_showPostsFragment)
    }
}