package com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.show_posts


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.ButtonInfo

open class ShowAllPostsFragment : ShowPostsFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        Log.d("GGER", "onPostClickListener: LOOOL1")
        viewModel.getAllPosts()
        viewModel.data.observe(viewLifecycleOwner) { posts ->
            posts.body()?.let { adapter.setList(it) }
        }
        return view
    }

    companion object {
        val buttonInfo =
            ButtonInfo("Show all posts", R.id.action_functionsFragment_to_showAllPostsFragment)
    }
}