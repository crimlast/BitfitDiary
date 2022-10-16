package com.example.bitfitandr1

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init

class JournalAdapter(private val context: Context, private val Entries: List<Diary>) :
    RecyclerView.Adapter<JournalAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.journal_entry, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val article = Entries[position]
            holder.bind(article)
        }

        override fun getItemCount() = Entries.size

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
            View.OnClickListener {

            private val dateTV = itemView.findViewById<TextView>(R.id.dateView)
            private val detailTV = itemView.findViewById<TextView>(R.id.detailView)
            private val moodTV = itemView.findViewById<TextView>(R.id.moodView)

            init {
                itemView.setOnClickListener(this)
            }

            fun bind(entry: Diary) {
                dateTV.text = entry.date
                detailTV.text = entry.detail
                moodTV.text = entry.mood.toString()

            }

            override fun onClick(v: View?) {
                // Get selected article

            }


        }

}
