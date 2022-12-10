package com.jds_code.theeverythingbagel

import android.app.Application
import com.jds_code.theeverythingbagel.database.notes.NotesRoomDatabase

class NotesApplication : Application() {
    // By using 'by lazy' the db and repository are made when needed only
    //  and not on application launch.
    val database: NotesRoomDatabase by lazy { NotesRoomDatabase.getDatabase(this) }
}