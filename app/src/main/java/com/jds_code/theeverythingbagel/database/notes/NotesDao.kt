import android.content.ClipData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    // 'OnConflictStrategy' ignores a new item if it's primary key is already in the database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes: Notes)

    @Update
    suspend fun update(notes: Notes)

    @Query("SELECT * from note WHERE id = :id")
    fun getItem(id: Int): Flow<Notes>

    @Query("SELECT * from note ORDER BY note_title ASC")
    fun getItems(): Flow<List<Notes>>
}