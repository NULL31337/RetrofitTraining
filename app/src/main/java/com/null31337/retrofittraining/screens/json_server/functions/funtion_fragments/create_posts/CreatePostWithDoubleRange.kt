package com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.create_posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentCratePostsDoubleRangeBinding
import com.null31337.retrofittraining.databinding.FragmentCratePostsTextRangeBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.ButtonInfo
import kotlinx.coroutines.runBlocking


class CreatePostWithDoubleRange : Fragment() {
    private lateinit var binding: FragmentCratePostsDoubleRangeBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCratePostsDoubleRangeBinding.inflate(layoutInflater, container, false)
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
            if (binding.rangeLeft.text.isEmpty()) {
                binding.rangeLeft.error = "Range left is required"
                return@setOnClickListener
            }
            if (binding.rangeRight.text.isEmpty()) {
                binding.rangeRight.error = "Range right is required"
                return@setOnClickListener
            }
            val rangeUserId =
                binding.userIdLeft.text.toString().toInt() to
                        binding.userIdRight.text.toString().toInt() + 1
            val rangeText =
                binding.rangeLeft.text.toString().toInt() to
                        binding.rangeRight.text.toString().toInt() + 1
            if (rangeText.first > rangeText.second) {
                binding.rangeLeft.error = "Left border must be not more than right border"
                binding.rangeRight.error = "Left border must be not more than right border"
                return@setOnClickListener
            }
            if (rangeText.second - rangeText.first  > 20) {
                binding.rangeLeft.error = "Pls create a smaller range"
                binding.rangeRight.error = "Pls create a smaller range"
                return@setOnClickListener
            }
            if (rangeUserId.first > rangeUserId.second) {
                binding.rangeLeft.error = "Left border must be not more than right border"
                binding.rangeRight.error = "Left border must be not more than right border"
                return@setOnClickListener
            }
            if (rangeUserId.second - rangeUserId.first  > 20) {
                binding.userIdLeft.error = "Pls create a smaller range"
                binding.userIdRight.error = "Pls create a smaller range"
                return@setOnClickListener
            }
            val rangeTextSize = rangeText.second - rangeText.first + 1
            val rangeUserIdSize = rangeUserId.second - rangeUserId.first + 1
            if (rangeTextSize > rangeUserIdSize) {
                var userId = rangeUserId.first
                val fragmentSize = rangeTextSize / rangeUserIdSize
                var cnt = 0
                for (i in rangeText.first..rangeText.second) {
                    val title = binding.title.text.toString().split("#").joinToString(i.toString())
                    val body = binding.body.text.toString().split("#").joinToString(i.toString())
                    Log.d("TAG", "init: $title \n $body")
                    viewModel.createPost(
                        Post(
                            userId,
                            0,
                            title,
                            body
                        )
                    )
                    cnt++
                    if (userId != rangeUserId.second && cnt == fragmentSize) {
                        userId++
                        cnt = 0
                    }
                }
            } else {
                var text = rangeText.first
                val fragmentSize = rangeUserIdSize / rangeTextSize
                var cnt = 0
                for (i in rangeUserId.first..rangeUserId.second) {
                    val title = binding.title.text.toString().split("#").joinToString(text.toString())
                    val body = binding.body.text.toString().split("#").joinToString(text.toString())
                    Log.d("TAG", "init: $title \n $body")
                    viewModel.createPost(
                        Post(
                            i,
                            0,
                            title,
                            body
                        )
                    )
                    cnt++
                    if (text != rangeUserId.second && cnt == fragmentSize) {
                        text++
                        cnt = 0
                    }
                }
            }

            FunctionsViewModel.waiting()
            APP.navController.navigateUp()
        }
    }

    companion object {
        val buttonInfo = ButtonInfo(
            "Create posts by interesting rule",
            R.id.action_functionsFragment_to_createPostWithDoubleRange
        )
    }
}