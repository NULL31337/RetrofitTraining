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
import com.null31337.retrofittraining.databinding.FragmentCratePostsTextRangeBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.ButtonInfo
import kotlinx.coroutines.runBlocking


class CreatePostWithRangeTextFragment : Fragment() {
    private lateinit var binding: FragmentCratePostsTextRangeBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCratePostsTextRangeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        init()

        return binding.root
    }

    private fun init() {
        binding.createBtn.setOnClickListener {
            if (binding.userId.text.isEmpty()) {
                binding.userId.error = "UserId left is required"
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
            val range =
                binding.rangeLeft.text.toString().toInt() to
                        binding.rangeRight.text.toString().toInt() + 1
            if (range.first > range.second) {
                binding.rangeLeft.error = "Left border must be not more than right border"
                binding.rangeRight.error = "Left border must be not more than right border"
                return@setOnClickListener
            }
            if (range.second - range.first > 20) {
                binding.rangeLeft.error = "Pls create a smaller range"
                binding.rangeRight.error = "Pls create a smaller range"
                return@setOnClickListener
            }

            for (i in range.first..range.second) {
                val title = binding.title.text.toString().split("#").joinToString(i.toString())
                val body = binding.body.text.toString().split("#").joinToString(i.toString())
                Log.d("TAG", "init: $title \n $body")
                viewModel.createPost(
                    Post(
                        binding.userId.text.toString().toInt(),
                        0,
                        title,
                        body
                    )
                )
            }
            Toast.makeText(APP, "Sending, wait 3 sec", Toast.LENGTH_LONG).show()
            runBlocking {
                Thread.sleep(3000)
            }
            APP.navController.navigateUp()
        }
    }

    companion object {
        val buttonInfo = ButtonInfo(
            "Create post with custom text and body in range",
            R.id.action_functionsFragment_to_createPostWithRangeTextFragment
        )
    }
}