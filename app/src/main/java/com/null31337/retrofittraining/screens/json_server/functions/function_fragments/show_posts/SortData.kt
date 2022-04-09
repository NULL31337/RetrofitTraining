package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import androidx.core.view.isGone
import com.null31337.retrofittraining.databinding.SortViewBinding

class SortData(private val binding: SortViewBinding) {
    private var isSorted: Boolean = false

    init {
        binding.group.isGone = true
        binding.sort.setOnClickListener {
            isSorted = !isSorted
            binding.group.isGone = !isSorted
        }
    }

    fun genRequest(map: MutableMap<String, String>, type: String) {
        if (isSorted) {
            map["_sort"] = type
            if (binding.ascending.isActivated) {
                map["_order"] = "asc"
            } else {
                map["_order"] = "desc"
            }
        }
    }
}