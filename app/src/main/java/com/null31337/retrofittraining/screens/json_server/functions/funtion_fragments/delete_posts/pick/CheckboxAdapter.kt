package com.null31337.retrofittraining.screens.json_server.functions.funtion_fragments.delete_posts.pick

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.model.functions.Post

class CheckboxAdapter : RecyclerView.Adapter<CheckboxAdapter.CheckboxViewHolder>() {
    inner class CheckboxViewHolder(view: View): RecyclerView.ViewHolder(view) {
    }

    private var data = emptyList<Post>()
    private var checkbox = MutableList(0) { false }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_post_with_checkbox, parent, false)
        return CheckboxViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckboxViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.userId).text = "userId: " + data[position].userId
        holder.itemView.findViewById<TextView>(R.id.id).text = "id: " + data[position].id
        holder.itemView.findViewById<TextView>(R.id.title).text = "title: " + data[position].title
        holder.itemView.findViewById<TextView>(R.id.body).text = "body: " + data[position].body
        holder.itemView.findViewById<CheckBox>(R.id.checkbox).isChecked = checkbox[position]
        holder.itemView.findViewById<CheckBox>(R.id.checkbox).setOnClickListener {
            checkbox[position] = !checkbox[position]
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Post>) {
        data = list;
        checkbox = MutableList(list.size) { false }
        notifyDataSetChanged()
    }

    fun getCheckedId(): List<Int>  {
        val answer = MutableList(0) { 0 }
        for ((i, v) in data.withIndex()) {
            if (checkbox[i]) {
                answer.add(v.id)
            }
        }
        return answer
    }
}