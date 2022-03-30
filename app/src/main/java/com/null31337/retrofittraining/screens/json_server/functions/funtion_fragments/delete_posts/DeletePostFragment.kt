package com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.delete_posts

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.ButtonInfo
import com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.show_posts.ShowAllPostsFragment

class DeletePostFragment : ShowAllPostsFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        adapter.listener = { position: Int ->
            val listener = DialogInterface.OnClickListener { _, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        viewModel.deleteById(adapter.data[position].id)
                        APP.navController.navigateUp()
                    }
                    else -> {}
                }
            }
            AlertDialog
                .Builder(APP)
                .setCancelable(false)
                .setTitle("Would you like delete this post?")
                .setMessage(
                    """
                        id: ${adapter.data[position].id}
                        userId: ${adapter.data[position].userId}
                        title: ${buildDialogString(adapter.data[position].title)}
                        body: ${buildDialogString(adapter.data[position].body)}
                    """.trimIndent()
                )
                .setPositiveButton("Delete", listener)
                .setNeutralButton("Close", listener)
                .create()
                .show()
        }
        return view
    }

    private val regex = "[\\n\\t ]".toRegex()
    private fun buildDialogString(string: String) =
        string.take(32).replace(regex, " ") + if (string.length > 32) "..." else ""

    companion object {
        val buttonInfo = ButtonInfo(
            "Delete from list",
            R.id.action_functionsFragment_to_deletePostFragment
        )
    }

}