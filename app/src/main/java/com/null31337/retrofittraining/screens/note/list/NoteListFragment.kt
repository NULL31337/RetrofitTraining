package com.null31337.retrofittraining.screens.note.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentListNoteBinding
import com.null31337.retrofittraining.model.note.NoteModel

class NoteListFragment : Fragment() {
    private lateinit var binding: FragmentListNoteBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        val viewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        viewModel.initDatabase()
        recyclerView = binding.notesRecyclerView
        noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter
        viewModel.getAllNotes()
            .observe(viewLifecycleOwner) { listNote -> noteAdapter.setList(listNote.asReversed()) }

        binding.btnAddNote.setOnClickListener {
            APP.navController.navigate(R.id.action_rootFragment_to_noteAddFragment)
        }
    }

    companion object {
        fun clickNote(noteModel: NoteModel) {
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP.navController.navigate(R.id.action_rootFragment_to_noteShowFragment, bundle)
        }
    }


}