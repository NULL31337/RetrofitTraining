package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentShowPageBinding
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId

class ShowPostsPager : Fragment() {
    private lateinit var binding: FragmentShowPageBinding
    private lateinit var viewModel: FunctionsViewModel
    private lateinit var adapter: ShowPostsAdapter
    private lateinit var recyclerView: RecyclerView
    private val pageSize = 3
    private var currentPage = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowPageBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        adapter = ShowPostsAdapter()
        recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

        init()

        return binding.root;
    }

    private fun genRequest() {
        binding.next.isGone = true
        binding.prev.isGone = true
        val endpoints = HashMap<String, String>()
        endpoints["_page"] = currentPage.toString()
        endpoints["_limit"] = pageSize.toString()
        viewModel.getByQueryMap(endpoints)
        viewModel.data.observe(viewLifecycleOwner) { post ->
            println(post.headers()["link"])
            post.body()?.let { it -> adapter.setList(it.toList()) }
            binding.next.isGone = false
            binding.prev.isGone = false
            if (post.headers()["link"]?.contains("rel=\"next\"") != true) {
                binding.next.isGone = true
            }
            if (post.headers()["link"]?.contains("rel=\"prev\"") != true) {
                binding.prev.isGone = true
            }
        }
    }

    private fun init() {
        genRequest()
        binding.prev.setOnClickListener {
            currentPage--
            genRequest()
        }
        binding.next.setOnClickListener {
            currentPage++
            genRequest()
        }
    }

    companion object {
        val buttonInfo = ButtonInfoId(
            "Show post page",
            R.id.action_functionsFragment_to_showPostsPager
        )
    }
}