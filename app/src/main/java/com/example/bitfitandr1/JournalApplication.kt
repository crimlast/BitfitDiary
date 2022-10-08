package com.example.bitfitandr1

import android.app.Application

class JournalApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}