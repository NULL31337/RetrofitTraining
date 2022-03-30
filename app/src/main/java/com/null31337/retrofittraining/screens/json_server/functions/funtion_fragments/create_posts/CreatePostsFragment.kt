package com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.create_posts

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentCratePostsBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.ButtonInfo

class CreatePostsFragment : Fragment() {
    private lateinit var binding: FragmentCratePostsBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCratePostsBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        init()


        return binding.root
    }

    private fun init() {
        binding.createBtn.setOnClickListener {
            if (binding.userId.text.isEmpty()) {
                binding.userId.error = "UserId is required"
            } else {
                viewModel.createPost(
                    Post(
                        binding.userId.text.toString().toInt(),
                        0,
                        binding.title.text.toString(),
                        binding.body.text.toString()
                    )
                )
                APP.navController.navigateUp()
            }
        }
    }

    companion object {
        val buttonInfo =
            ButtonInfo("Create post", R.id.action_functionsFragment_to_createPostsFragment)
    }
}