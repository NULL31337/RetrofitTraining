package com.null31337.retrofittraining.screens.json_server.functions.function_fragments

import com.null31337.retrofittraining.databinding.RangeViewBinding

open class RangeData(private val text: String = "Range", private val binding:RangeViewBinding, private val range_size: Int = 20) {
    init {
        binding.left.hint = "$text from: "
        binding.right.hint = "$text to: "
    }
    fun getData() : Pair<Int, Int>? {
        if (binding.left.text.isEmpty()) {
            binding.left.error = "$text left is required"
            return null
        }
        if (binding.right.text.isEmpty()) {
            binding.right.error = "$text right is required"
            return null
        }
        val range =
            binding.left.text.toString().toInt() to
                    binding.right.text.toString().toInt() + 1
        if (range.first > range.second) {
            binding.left.error = "Left border must be not more than right border"
            binding.right.error = "Left border must be not more than right border"
            return null
        }
        if (range.second - range.first > range_size) {
            binding.right.error = "Pls create a smaller range"
            binding.left.error = "Pls create a smaller range"
            return null
        }
        return range
    }
}

class RangeUserIdData(binding: RangeViewBinding, range_size: Int = 20) : RangeData("UserId", binding, range_size)
class RangeIdData(binding: RangeViewBinding, range_size: Int = 20) : RangeData("Id", binding, range_size)