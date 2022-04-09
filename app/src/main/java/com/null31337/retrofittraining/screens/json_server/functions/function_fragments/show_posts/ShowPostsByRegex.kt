package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentShowPostsRegexBinding
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId

class ShowPostsByRegex : Fragment() {
    private lateinit var binding: FragmentShowPostsRegexBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowPostsRegexBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        init()

        return binding.root
    }

    private fun init() {
        binding.getBtn.setOnClickListener {
            if (binding.text.text.isEmpty()) {
                binding.text.error = "Empty"
                return@setOnClickListener
            }
            val endpoints = HashMap<String, String>()
            if (binding.title.isActivated) {
                endpoints["title_like"] = binding.text.text.toString()
            } else {
                endpoints["body_like"] = binding.text.text.toString()
            }
            viewModel.getByQueryMap(endpoints)
            viewModel.data.observe(viewLifecycleOwner) { post ->
                post.body()?.let {
                    APP.navController.navigate(
                        ShowPostsByRegexDirections.actionShowPostsByRegexToShowPostsFragment(
                            it.toTypedArray()
                        )
                    )
                }
            }
        }
    }

    companion object {
        val buttonInfo =
            ButtonInfoId("Show posts Regex", R.id.action_functionsFragment_to_showPostsByRegex)
    }

}