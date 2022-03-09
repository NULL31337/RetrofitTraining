package com.null31337.retrofittraining.screens.note.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentShowNoteBinding
import com.null31337.retrofittraining.model.note.NoteModel

class NoteShowFragment : Fragment() {
    private lateinit var binding: FragmentShowNoteBinding
    private lateinit var currentNode: NoteModel
    private lateinit var viewModel: NoteShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowNoteBinding.inflate(layoutInflater, container, false)
        currentNode = arguments?.getSerializable("note") as NoteModel
        binding.noteText.text = currentNode.text
        binding.noteTitle.text = currentNode.title
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[NoteShowViewModel::class.java]
        binding.btnDeleteNote.setOnClickListener {
            viewModel.delete(currentNode) {}
            APP.navController.navigate(R.id.action_noteShowFragment_to_rootFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_noteShowFragment_to_rootFragment)
        }
    }
}