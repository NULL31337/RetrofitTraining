package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentCreatePostsDoubleRangeBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.RangeData
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.RangeUserIdData


class CreatePostWithDoubleRange : Fragment() {
    private lateinit var binding: FragmentCreatePostsDoubleRangeBinding
    private lateinit var viewModel: FunctionsViewModel
    private lateinit var rangeData: RangeData
    private lateinit var rangeUserIdData: RangeData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatePostsDoubleRangeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        init()

        return binding.root
    }

    private fun init() {
        rangeData = RangeData(binding = binding.range)
        rangeUserIdData = RangeUserIdData(binding.rangeUserId)
        binding.createBtn.setOnClickListener {
            val rangeText = rangeData.getData() ?: return@setOnClickListener
            val rangeUserId = rangeUserIdData.getData() ?: return@setOnClickListener
            val rangeTextSize = rangeText.second - rangeText.first + 1
            val rangeUserIdSize = rangeUserId.second - rangeUserId.first + 1
            if (rangeTextSize > rangeUserIdSize) {
                var userId = rangeUserId.first
                val fragmentSize = rangeTextSize / rangeUserIdSize
                var cnt = 0
                for (i in rangeText.first..rangeText.second) {
                    val title = binding.title.text.toString().split("#").joinToString(i.toString())
                    val body = binding.body.text.toString().split("#").joinToString(i.toString())
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
                    val title =
                        binding.title.text.toString().split("#").joinToString(text.toString())
                    val body = binding.body.text.toString().split("#").joinToString(text.toString())
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
        val buttonInfo = ButtonInfoId(
            "Create posts by interesting rule",
            R.id.action_functionsFragment_to_createPostWithDoubleRange
        )
    }
}