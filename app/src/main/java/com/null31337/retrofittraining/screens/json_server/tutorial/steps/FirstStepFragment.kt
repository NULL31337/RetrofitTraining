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
import com.null31337.retrofittraining.databinding.TutorialOneFragmentBinding


class FirstStepFragment : Fragment(){
    private lateinit var binding: TutorialOneFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TutorialOneFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        binding.linkBtn.setOnClickListener {
            val clipboard: ClipboardManager = APP.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newHtmlText("Local Json server", "https://github.com/typicode/json-server", "https://github.com/typicode/json-server")
            clipboard.setPrimaryClip(clip)
        }

        binding.openLinkBtn.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/typicode/json-server"))
            startActivity(browserIntent)
        }
    }
}