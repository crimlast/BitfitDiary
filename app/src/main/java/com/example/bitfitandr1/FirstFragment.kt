package com.example.bitfitandr1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfitandr1.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch


class FirstFragment : Fragment() {
    private val journals = mutableListOf<Diary>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var journalAdapter: JournalAdapter
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_diary_entries, container, false)
        lifecycleScope.launch {
            (activity?.application as JournalApplication).db.journalDao().getAll()
                .collect { databaseList ->
                    databaseList.map { entry ->
                        Diary(
                            entry.date,
                            entry.detail,
                            entry.mood
                        )
                    }.also { mappedList ->
                        journals.clear()
                        journals.addAll(mappedList)
                        journalAdapter.notifyDataSetChanged()
                    }
                }
        }
        // Add these configurations for the recyclerView and to configure the adapter
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.list)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        journalAdapter = JournalAdapter(view.context, journals)
        recyclerView.adapter = journalAdapter

        val button = view.findViewById<Button>(R.id.button2);


        button.setOnClickListener {
            activity?.let{
                val intent = Intent (it, DetailActivity::class.java)
                it.startActivity(intent)
            }
        }


        // Update the return statement to return the inflated view from above
        return view
        // Inflate the layout for this fragment
    }








}