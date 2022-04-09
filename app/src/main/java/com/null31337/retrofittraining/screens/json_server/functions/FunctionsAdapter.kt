package com.null31337.retrofittraining.screens.json_server.functions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts.*
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.delete_posts.DeleteByUsersIdFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.delete_posts.DeletePostFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.delete_posts.DeletePostPickFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.edit_post.OpenPostFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts.*

class FunctionsAdapter : RecyclerView.Adapter<FunctionsAdapter.FunctionsViewHolder>() {
    class FunctionsViewHolder(view: View) : RecyclerView.ViewHolder(view)

    val data = listOf(
        DeletePostPickFragment.buttonInfo,
        DeleteByUsersIdFragment.buttonInfo,
        DeletePostFragment.buttonInfo,
        ShowAllPostsFragment.buttonInfo,
        ShowPostsInRangeFragment.buttonInfo,
        ShowPostsInNumberRange.buttonInfo,
        ShowPostsPager.buttonInfo,
        ShowPostsByRegex.buttonInfo,
        ShowPostsByFullSearch.buttonInfo,
        OpenPostFragment.buttonInfo,
        CreatePostsFragment.buttonInfo,
        CreatePostWithDoubleRange.buttonInfo,
        CreatePostUserIdRangeFragment.buttonInfo,
        CreatePostWithRangeTextFragment.buttonInfo,
        CreatePostRandomFragment.buttonInfo
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunctionsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_function, parent, false)
        return FunctionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FunctionsViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.function_item).text = data[position].name
        holder.itemView.findViewById<TextView>(R.id.function_item).setOnClickListener {
            data[position].navigate()
        }
    }

    override fun getItemCount(): Int = data.size
}