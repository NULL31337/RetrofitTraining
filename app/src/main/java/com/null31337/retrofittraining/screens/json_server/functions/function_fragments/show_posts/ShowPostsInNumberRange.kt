package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentShowPostsNumberRangeBinding
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.RangeData

class ShowPostsInNumberRange : Fragment() {
    private lateinit var rangeData: RangeData
    private lateinit var binding: FragmentShowPostsNumberRangeBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowPostsNumberRangeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        rangeData = RangeData("Number of post", binding.range, Int.MAX_VALUE)

        init()

        return binding.root
    }

    private fun init() {
        binding.getBtn.setOnClickListener {
            val range = rangeData.getData() ?: return@setOnClickListener
            val endpoints = HashMap<String, String>()
            endpoints["_start"] = range.first.toString()
            endpoints["_end"] = range.second.toString()
            viewModel.getByQueryMap(endpoints)
            viewModel.data.observe(viewLifecycleOwner) { post ->
                post.body()?.let {
                    APP.navController.navigate(
                        ShowPostsInNumberRangeDirections.actionShowPostsInNumberRangeToShowPostsFragment(
                            it.toTypedArray()
                        )
                    )
                }
            }
        }
    }

    companion object {
        val buttonInfo = ButtonInfoId(
            "Show posts in number range",
            R.id.action_functionsFragment_to_showPostsInNumberRange
        )
    }
}