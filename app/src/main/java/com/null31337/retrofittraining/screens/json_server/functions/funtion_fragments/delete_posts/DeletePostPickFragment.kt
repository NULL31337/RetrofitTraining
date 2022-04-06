package com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.delete_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentDeletePostsByPickBinding
import com.null31337.retrofittraining.databinding.FragmentShowPostsBinding
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel.Companion.waiting
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.ButtonInfo
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.delete_posts.pick.CheckboxAdapter
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.show_posts.ShowPostsAdapter

class DeletePostPickFragment : Fragment() {
    private lateinit var binding: FragmentDeletePostsByPickBinding
    private lateinit var viewModel: FunctionsViewModel
    private lateinit var adapter: CheckboxAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeletePostsByPickBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        adapter = CheckboxAdapter()
        binding.showPosts.functionsBtns.adapter = adapter
        init()

        return binding.root
    }

    private fun init() {
        viewModel.getAllPosts()
        viewModel.data.observe(viewLifecycleOwner) { post ->
            post.body()?.let { adapter.setData(it) }
        }
        binding.deleteBtn.setOnClickListener {
            adapter.getCheckedId().forEach {
                viewModel.deleteById(it)
            }
            waiting()
            APP.navController.navigateUp()
        }
    }

    companion object {
        val buttonInfo =
            ButtonInfo("Delete posts by pick", R.id.action_functionsFragment_to_deletePostPickFragment);
    }

}