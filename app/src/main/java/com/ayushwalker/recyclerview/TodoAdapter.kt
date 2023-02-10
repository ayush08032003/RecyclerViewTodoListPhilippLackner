package com.ayushwalker.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// This adapter need to know, which data needs to show up
class TodoAdapter (
    var todos : List<Todo> // This is for showing that the adapter class will take a list of data class todos
        ) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    //in constructor we need to pass view
    inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) // this is very important..!

    // This functions invoke when the system needs a new ViewHolder, For ex: the user scrolls down a bit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)
    }

    // The purpose of this function is to bind the data into our items, take the data from the todos list and set it into corresponding view
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tvTitle)
            tvTitle.text = todos[position].title
            val cbDone = findViewById<CheckBox>(R.id.cbDone)
            cbDone.isChecked = todos[position].isChecked
        }
    }

    // This returns the count of how many items we have in our recycler view, it is the simplest function, common mistake: write return 0, that means
    // we have zero items in our recyclerView, most cases: size of list
    override fun getItemCount(): Int {
        return todos.size
    }
}