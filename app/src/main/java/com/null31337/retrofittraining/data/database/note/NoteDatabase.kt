package com.null31337.retrofittraining.data.database.note

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.null31337.retrofittraining.data.dao.NoteDao
import com.null31337.retrofittraining.model.note.NoteModel


@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private var database: NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            if (database == null) {
                database =
                    Room.databaseBuilder(context, NoteDatabase::class.java, "db").build()
            }
            return database as NoteDatabase
        }
    }
}