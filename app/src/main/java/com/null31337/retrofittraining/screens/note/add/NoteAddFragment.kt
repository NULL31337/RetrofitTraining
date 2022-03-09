package com.null31337.retrofittraining.screens.note.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.null31337.retrofittraining.APP
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.databinding.FragmentAddNoteBinding
import com.null31337.retrofittraining.model.note.NoteModel

class NoteAddFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[NoteAddViewModel::class.java]
        binding.btnAddNote.setOnClickListener {
            val title = binding.noteTitle.text.toString()
            val text = binding.noteText.text.toString()
            viewModel.insert(NoteModel(title = title, text = text)) {}
            APP.navController.navigate(R.id.action_noteAddFragment_to_rootFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_noteAddFragment_to_rootFragment)
        }
    }

}