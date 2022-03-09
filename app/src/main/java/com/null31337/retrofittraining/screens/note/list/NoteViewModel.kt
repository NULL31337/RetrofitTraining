package com.null31337.retrofittraining.screens.note.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.null31337.retrofittraining.REPOSITORY
import com.null31337.retrofittraining.data.database.note.NoteDatabase
import com.null31337.retrofittraining.data.repository.note.NoteRealization

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes() = REPOSITORY.data
}