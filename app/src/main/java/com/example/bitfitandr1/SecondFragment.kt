package com.example.bitfitandr1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SecondFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)


        val avg = view.findViewById<TextView>(R.id.moodAverage)
        val num = view.findViewById<TextView>(R.id.entries_number)

        lifecycleScope.launch(Dispatchers.IO) {
            val m = (activity?.application as JournalApplication).db.journalDao().averageMood()
            val b = (activity?.application as JournalApplication).db.journalDao().getRowCount()
            avg.text = m.toString()
            num.text = b.toString()
        }

        // Inflate the layout for this fragment
        return view
    }



}