package com.kidnapsteal.commit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kidnapsteal.commit.data.entity.Commit

class CommitAdapter : RecyclerView.Adapter<CommitViewHolder>() {

    var data: List<Commit> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_commit, parent, false)
        return CommitViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
        holder.bindView(data[position])
    }
}

class CommitViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textAuthor: TextView = view.findViewById(R.id.textAuthor)
    val textMessage: TextView = view.findViewById(R.id.textMessage)

    fun bindView(commit: Commit) {
        textAuthor.text = commit.author.name
        textMessage.text = commit.message
    }

}