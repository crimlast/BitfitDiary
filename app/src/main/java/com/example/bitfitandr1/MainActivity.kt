package com.example.bitfitandr1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfitandr1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val journals = mutableListOf<Diary>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list)
        val diaryAdapter = JournalAdapter(this, journals)
        recyclerView.adapter = diaryAdapter

        recyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            recyclerView.addItemDecoration(dividerItemDecoration)
        }

        val button = findViewById<Button>(R.id.button2);
        lifecycleScope.launch {
            (application as JournalApplication).db.journalDao().getAll().collect {
                    databaseList ->
                databaseList.map { entry ->
                    Diary(
                        entry.date,
                        entry.detail,
                    )
                }.also { mappedList ->
                    journals.clear()
                    journals.addAll(mappedList)
                    diaryAdapter.notifyDataSetChanged()
                }
            }
        }

        button.setOnClickListener {
            val myIntent = Intent(this, DetailActivity::class.java)
            startActivityForResult(myIntent, 0)
        }

    }
}