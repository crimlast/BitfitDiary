package com.example.bitfitandr1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_detail)

        val button = findViewById<Button>(R.id.button)
        val detail = findViewById<EditText>(R.id.detail_input)
        val date = findViewById<EditText>(R.id.date_input)

        button.setOnClickListener {
            lifecycleScope.launch(IO) {
                val j = Diary(date.text.toString(), detail.text.toString())
                (application as JournalApplication).db.journalDao().insert(j)
            }
            val myIntent = Intent(this, MainActivity::class.java)
            startActivityForResult(myIntent, 0)
        }


    }

}