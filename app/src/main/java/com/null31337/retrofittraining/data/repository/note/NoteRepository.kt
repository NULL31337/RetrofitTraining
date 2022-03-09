package com.null31337.retrofittraining.data.repository.note

import androidx.lifecycle.LiveData
import com.null31337.retrofittraining.model.note.NoteModel

interface NoteRepository {
    val data: LiveData<List<NoteModel>>

    suspend fun insert(note: NoteModel, onSuccess: () -> Unit)
    suspend fun delete(note: NoteModel, onSuccess: () -> Unit)
}