@file:Suppress(
    "RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType"
)

package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentCreatePostsRandomBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo
import kotlin.random.Random
import kotlin.random.nextUInt

class CreatePostRandomFragment : Fragment() {
    private lateinit var binding: FragmentCreatePostsRandomBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatePostsRandomBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        init()

        return binding.root
    }

    private fun init() {
        binding.createBtn.setOnClickListener {
            if (binding.count.text.isEmpty()) {
                binding.count.error = "UserId left is required"
                return@setOnClickListener
            }
            val count = binding.count.text.toString().toInt()
            if (count >= 100) {
                binding.count.error = "WOW Stop pls. Tty number lower then 100"
                return@setOnClickListener
            }
            for (i in 1..count) {
                viewModel.createPost(
                    Post(
                        Random.nextUInt().toInt(),
                        0,
                        generateText(),
                        generateText()
                    )
                )
            }

            FunctionsViewModel.waiting()
            APP.navController.navigateUp()
        }

    }


    companion object {
        val buttonInfo =
            ButtonInfo(
                "Create random posts",
                R.id.action_functionsFragment_to_createPostRandomFragment
            )

        fun generateText() = buildString {
            repeat(50) {
                append('a' + Random.nextInt() % 26)
            }
        }
    }

}