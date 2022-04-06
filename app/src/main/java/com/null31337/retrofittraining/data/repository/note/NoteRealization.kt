package com.null31337.retrofittraining.data.repository.note

import androidx.lifecycle.LiveData
import com.null31337.retrofittraining.data.dao.NoteDao
import com.null31337.retrofittraining.model.note.NoteModel

class NoteRealization(private val noteDao: NoteDao) : NoteRepository {
    override val data: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insert(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(note)
        onSuccess()
    }
}