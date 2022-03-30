package com.null31337.retrofittraining.screens.json_server.tutorial.steps

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.databinding.TutorialThreeFragmentBinding
import com.null31337.retrofittraining.databinding.TutorialTwoFragmentBinding


class ThirdStepFragment : Fragment(){
    private lateinit var binding: TutorialThreeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TutorialThreeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        binding.finish.setOnClickListener {
            APP.navController.navigateUp()
        }
    }
}