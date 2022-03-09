package com.null31337.retrofittraining.screens.note.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.null31337.retrofittraining.REPOSITORY
import com.null31337.retrofittraining.model.note.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteAddViewModel : ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY.insert(noteModel) {
                onSuccess()
            }
        }
    }
}