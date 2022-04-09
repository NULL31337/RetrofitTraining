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
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsFragmentDirections
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoNavigation

open class ShowAllPostsFragment : Fragment() {
    protected lateinit var adapter: ShowPostsAdapter
    protected lateinit var viewModel: FunctionsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentShowPostsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowPostsBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        recyclerView = binding.functionsBtn
        adapter = ShowPostsAdapter()
        recyclerView.adapter = adapter

        viewModel.getAllPosts()
        viewModel.data.observe(viewLifecycleOwner) { posts ->
            posts.body()?.let { adapter.setList(it) }
        }

        return binding.root
    }

    companion object {
        val buttonInfo =
            ButtonInfoId("Show all posts", R.id.action_functionsFragment_to_showAllPostsFragment)
    }
}