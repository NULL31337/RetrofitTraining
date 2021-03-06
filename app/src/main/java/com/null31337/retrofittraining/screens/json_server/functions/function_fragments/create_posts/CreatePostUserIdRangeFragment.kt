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
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.RangeData
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.RangeUserIdData

class CreatePostUserIdRangeFragment : Fragment() {
    private lateinit var binding: FragmentCreatePostsUseridRangeBinding
    private lateinit var viewModel: FunctionsViewModel
    private lateinit var rangeData: RangeData

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
        rangeData = RangeUserIdData(binding.range)
        binding.createBtn.setOnClickListener {
            val range = rangeData.getData() ?: return@setOnClickListener
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
        val buttonInfo = ButtonInfoId(
            "Create post in userId range",
            R.id.action_functionsFragment_to_createPostUserIdRangeFragment
        )
    }
}