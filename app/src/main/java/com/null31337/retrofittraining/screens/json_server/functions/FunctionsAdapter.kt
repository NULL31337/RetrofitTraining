package com.null31337.retrofittraining.screens.json_server.functions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts.CreatePostRandomFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts.CreatePostUserIdRangeFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts.CreatePostWithRangeTextFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.create_posts.CreatePostsFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.delete_posts.DeleteByUsersIdFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.delete_posts.DeletePostFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.delete_posts.DeletePostPickFragment
import com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts.ShowAllPostsFragment

class FunctionsAdapter : RecyclerView.Adapter<FunctionsAdapter.FunctionsViewHolder>() {
    class FunctionsViewHolder(view: View) : RecyclerView.ViewHolder(view)

    val data = listOf(
        DeletePostPickFragment.buttonInfo,
        DeleteByUsersIdFragment.buttonInfo,
        ShowAllPostsFragment.buttonInfo,
        DeletePostFragment.buttonInfo,
        CreatePostsFragment.buttonInfo,
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
            APP.navController.navigate(data[position].navigation)
        }
    }

    override fun getItemCount(): Int = data.size
}