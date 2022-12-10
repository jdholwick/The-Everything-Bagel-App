package com.jds_code.theeverythingbagel.database.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// One entity since we only use "Notes," the version number is 1 but will
//  have to go up whenever the schema of the DB table is changed for tracking,
//  and exportSchema == false so schema version history isn't backed up.
@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesRoomDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        // The value of a volatile variable is never chached, and all writes
        //  and reads are done main memory.
        @Volatile
        private var INSTANCE: NotesRoomDatabase? = null

        fun getDatabase(context: Context): NotesRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesRoomDatabase::class.java,
                    "notes_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}