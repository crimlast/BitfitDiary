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

            init {
                itemView.setOnClickListener(this)
            }

            fun bind(entry: Diary) {
                dateTV.text = entry.date
                detailTV.text = entry.detail

            }

            override fun onClick(v: View?) {
                // Get selected article

            }
        }

}

//class EmailAdapter(private val emails: List<ContactsContract.CommonDataKinds.Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        // Your holder should contain a member variable for any view that will be set as you render
//        // a row
//        val senderTextView: TextView
//        val titleTextView: TextView
//        val summaryTextView: TextView
//
//        // We also create a constructor that accepts the entire item row
//        // and does the view lookups to find each sub-view
//        init {
//            // Stores the itemView in a public final member variable that can be used
//            // to access the context from any ViewHolder instance.
//            senderTextView = itemView.findViewById(R.id.senderTv)
//            titleTextView = itemView.findViewById(R.id.titleTv)
//            summaryTextView = itemView.findViewById(R.id.summaryTv)
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val context = parent.context
//        val inflater = LayoutInflater.from(context)
//        // Inflate the custom layout
//        val contactView = inflater.inflate(R.layout.email_item, parent, false)
//        // Return a new holder instance
//        return ViewHolder(contactView)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        // Get the data model based on position
//        val email = emails.get(position)
//        // Set item views based on views and data model
//        holder.senderTextView.text = email.sender
//        holder.titleTextView.text = email.title
//        holder.summaryTextView.text = email.summary
//    }
//
//    override fun getItemCount(): Int {
//        return emails.size
//    }
//}