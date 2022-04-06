package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.delete_posts

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentDeletePostsUseridBinding
import com.null31337.retrofittraining.model.functions.Post
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel
import com.null31337.retrofittraining.screens.json_server.functions.FunctionsViewModel.Companion.waiting
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.ButtonInfo

class DeleteByUsersIdFragment : Fragment() {
    private lateinit var binding: FragmentDeletePostsUseridBinding
    private lateinit var viewModel: FunctionsViewModel
    private var data = emptyList<Post>()
    private var userIds = mutableSetOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeletePostsUseridBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[FunctionsViewModel::class.java]
        viewModel.getAllPosts()
        viewModel.data.observe(viewLifecycleOwner) { posts ->
            posts.body()?.let { it ->
                data = it
                data.forEach { userIds.add(it.userId) }
            }
        }

        init()

        return binding.root
    }

    private fun init() {
        binding.deleteBtn.setOnClickListener {
            if (data.isEmpty()) {
                Toast.makeText(APP, "Wait applying data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val userIdListString = binding.text.text.toString().split(", ")
            lateinit var userIdList: List<Int>
            try {
                userIdList = userIdListString.map(String::toInt).sorted()
            } catch (e: NumberFormatException) {
                binding.text.error = "Wrong format!"
                return@setOnClickListener
            }
            data.forEach {
                if (userIdList.contains(it.userId)) {
                    viewModel.deleteById(it.id)
                }
            }
            waiting()
            APP.navController.navigateUp()
        }
        binding.alertCreateBtn.setOnClickListener {
            if (data.isEmpty()) {
                Toast.makeText(APP, "Wait applying data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userIdsString = userIds.map(Int::toString).toTypedArray()
            val checkboxes = BooleanArray(data.size)

            val listener = DialogInterface.OnClickListener { _, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    val listOfDeletable = buildList {
                        for ((i, v) in userIdsString.withIndex()) {
                            if (checkboxes[i]) {
                                add(v)
                            }
                        }
                    }
                    binding.text.setText(listOfDeletable.joinToString(", "))
                }
            }

            val alertDialog = AlertDialog.Builder(APP)
                .setTitle("Pick UserId's")
                .setMultiChoiceItems(userIdsString, checkboxes) { _, position, isChecked ->
                    checkboxes[position] = isChecked
                }
                .setPositiveButton("Create", listener)
            alertDialog.show()
        }
    }


    companion object {
        val buttonInfo =
            ButtonInfo("Delete by UserId", R.id.action_functionsFragment_to_deleteByUsersIdFragment)
    }
}