package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentCreatePostsUseridRangeBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo

class CreatePostUserIdRangeFragment : Fragment() {
    private lateinit var binding: FragmentCreatePostsUseridRangeBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatePostsUseridRangeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        init()

        return binding.root
    }

    private fun init() {
        binding.createBtn.setOnClickListener {
            if (binding.userIdLeft.text.isEmpty()) {
                binding.userIdLeft.error = "UserId left is required"
                return@setOnClickListener
            }
            if (binding.userIdRight.text.isEmpty()) {
                binding.userIdRight.error = "UserId right is required"
                return@setOnClickListener
            }
            val range =
                binding.userIdLeft.text.toString().toInt() to
                        binding.userIdRight.text.toString().toInt() + 1
            if (range.first > range.second) {
                binding.userIdLeft.error = "Left border must be not more than right border"
                binding.userIdRight.error = "Left border must be not more than right border"
                return@setOnClickListener
            }
            if (range.second - range.first > 20) {
                binding.userIdLeft.error = "Pls create a smaller range"
                binding.userIdRight.error = "Pls create a smaller range"
                return@setOnClickListener
            }
            for (i in range.first..range.second) {
                viewModel.createPost(
                    Post(
                        i,
                        0,
                        binding.title.text.toString(),
                        binding.body.text.toString()
                    )
                )
            }

            FunctionsViewModel.waiting()
            APP.navController.navigateUp()
        }
    }

    companion object {
        val buttonInfo = ButtonInfo(
            "Create post in userId range",
            R.id.action_functionsFragment_to_createPostUserIdRangeFragment
        )
    }
}