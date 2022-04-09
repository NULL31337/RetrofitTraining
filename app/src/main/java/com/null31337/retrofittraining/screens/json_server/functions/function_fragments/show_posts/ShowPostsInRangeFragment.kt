package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentShowInRangeBinding
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.RangeData
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.RangeUserIdData

class ShowPostsInRangeFragment : Fragment() {
    private lateinit var binding: FragmentShowInRangeBinding
    private lateinit var viewModel: FunctionsViewModel
    private lateinit var rangeData: RangeData
    private lateinit var sortData: SortData
    private var endpoints: MutableMap<String, String> = HashMap()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowInRangeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        init()

        return binding.root
    }

    private fun init() {
        rangeData = RangeUserIdData(binding.range, Int.MAX_VALUE)
        sortData = SortData(binding.sort)
        binding.getBtn.setOnClickListener {
            val range = rangeData.getData() ?: return@setOnClickListener
            val type = if (binding.id.isChecked) "id" else "userId"
            endpoints["${type}_gte"] = range.first.toString()
            endpoints["${type}_lte"] = range.second.toString()
            sortData.genRequest(endpoints, type)
            viewModel.getByQueryMap(endpoints)
            viewModel.data.observe(viewLifecycleOwner) { post ->
                post?.body()?.let {
                    APP.navController.navigate(
                        ShowPostsInRangeFragmentDirections.actionShowPostsInRangeFragmentToShowPostsFragment(
                            it.toTypedArray()
                        )
                    )
                }
            }
        }
    }

    companion object {
        val buttonInfo = ButtonInfoId(
            "Show posts in range",
            R.id.action_functionsFragment_to_showPostsInRangeFragment
        )
    }
}