package com.null31337.retrofittraining.screens.json_server.menu

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.FUNCTIONS_URL
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.data.api.functions.RetrofitInstance
import com.null31337.retrofittraining.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        binding.explanationText.setOnClickListener {
            val clipboard: ClipboardManager = APP.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newHtmlText("Json server", "https://jsonplaceholder.typicode.com/", "https://jsonplaceholder.typicode.com/")
            clipboard.setPrimaryClip(clip)
        }

        binding.tutorialBtn.setOnClickListener {
            APP.navController.navigate(R.id.action_rootFragment_to_tutorialFragment)
        }
        binding.functionsBtn.setOnClickListener {
            FUNCTIONS_URL = binding.baseUrlText.text.toString()
            APP.navController.navigate(R.id.action_rootFragment_to_functionsFragment)
        }
    }
}