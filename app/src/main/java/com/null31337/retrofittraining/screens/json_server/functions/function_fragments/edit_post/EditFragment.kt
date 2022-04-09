package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.edit_post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.databinding.FragmentEditPostBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel.Companion.waiting

class EditFragment : Fragment() {
    val args: EditFragmentArgs by navArgs()
    private lateinit var binding: FragmentEditPostBinding
    private lateinit var viewModel: FunctionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditPostBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]

        init()

        return binding.root
    }

    private fun init() {
        binding.body.setText(args.post.body)
        binding.title.setText(args.post.title)
        binding.userId.setText(args.post.userId.toString())

        binding.submitBtn.setOnClickListener {
            viewModel.putPost(
                Post(
                    binding.userId.text.toString().toInt(),
                    args.post.id,
                    binding.title.text.toString(),
                    binding.body.text.toString()
                )
            )
            waiting()
            APP.navController.navigateUp()
        }
    }

}