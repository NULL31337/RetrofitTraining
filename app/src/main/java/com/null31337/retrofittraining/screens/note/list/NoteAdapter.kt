package com.null31337.retrofittraining.screens.note.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.model.note.NoteModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var data = emptyList<NoteModel>()


    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.note_item).text = data[position].title
        holder.itemView.setOnClickListener {
            NoteListFragment.clickNote(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setList(l: List<NoteModel>) {
        data = l
        notifyDataSetChanged()
    }
}