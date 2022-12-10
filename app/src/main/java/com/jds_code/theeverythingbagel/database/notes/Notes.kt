package com.jds_code.theeverythingbagel.database.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

@Entity
data class Notes(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "note_title") val noteTitle: String,
    @ColumnInfo(name = "note_body") val noteBody: String,
)