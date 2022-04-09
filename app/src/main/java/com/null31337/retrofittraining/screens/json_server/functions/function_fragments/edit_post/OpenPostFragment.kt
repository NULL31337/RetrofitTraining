package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.edit_post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfoId
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts.ShowAllPostsFragment

class OpenPostFragment : ShowAllPostsFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState:
        Bundle?
    ): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        adapter.listener = {
            APP.navController.navigate(
                OpenPostFragmentDirections.actionOpenPostFragmentToEditFragment(
                    adapter.data[it]
                )
            )
        }
        return view
    }

    companion object {
        val buttonInfo = ButtonInfoId("Edit post", R.id.action_functionsFragment_to_openPostFragment)
    }
}