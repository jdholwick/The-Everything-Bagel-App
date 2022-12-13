package com.jds_code.theeverythingbagel.database.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * from notes ORDER BY title ASC")
    fun getItems(): Flow<List<Notes>>

    @Query("SELECT * from notes WHERE id = :id")
    fun getItem(id: Int): Flow<Notes>

    // 'OnConflictStrategy' ignores a new item if it's primary key is already in the database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes: Notes)

    @Update
    suspend fun update(notes: Notes)
}