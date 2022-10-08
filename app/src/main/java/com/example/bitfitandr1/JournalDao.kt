package com.example.bitfitandr1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal")
    fun getAll(): Flow<List<Diary>>

    @Query("DELETE FROM journal")
    fun deleteAll()

    @Insert
    fun insertAll(journals: List<Diary>)

    @Insert
    fun insert(journal: Diary)


}