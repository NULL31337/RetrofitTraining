package com.null31337.retrofittraining.screens.json_server.functions.function_fragments.show_posts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.model.functions.Post

class ShowPostsAdapter : RecyclerView.Adapter<ShowPostsAdapter.ShowPostsViewHolder>() {
    inner class ShowPostsViewHolder(view: View) : RecyclerView.ViewHolder(view)

    var data = emptyList<Post>()
    var listener: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowPostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_post, parent, false)
        return ShowPostsViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ShowPostsViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.userId).text =
            "userId: " + data[position].userId
        holder.itemView.findViewById<TextView>(R.id.id).text = "id: " + data[position].id
        holder.itemView.findViewById<TextView>(R.id.title).text = "title: " + data[position].title
        holder.itemView.findViewById<TextView>(R.id.body).text = "body: " + data[position].body
        holder.itemView.setOnClickListener {
            listener?.invoke(position)
        }
    }

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(l: List<Post>) {
        data = l
        notifyDataSetChanged()
    }
}