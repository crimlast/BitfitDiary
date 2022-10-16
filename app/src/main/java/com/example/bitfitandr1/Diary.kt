package com.example.bitfitandr1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal")
data class Diary(
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "detail") val detail: String?,
    @ColumnInfo(name = "mood") val mood: Int?,
    @PrimaryKey(autoGenerate = true) val id:Long = 0,
    )