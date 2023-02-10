package com.ayushwalker.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf(
            Todo("Follow Philipp Lackner", false),
            Todo("Learn About Recycler View", true),
            Todo("Learn About DBMS and SQL Queries", false),
            Todo("Solve Yesterday's Contest Question", true)
        )

        val adapter = TodoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        btnAddTodo.setOnClickListener {
            val etTodo = findViewById<EditText>(R.id.etTodo)
            val text = etTodo.text.toString()
            val todo = Todo(text,false)
            todoList.add(todo) // this will surely update todolist but not update the recycler view Items
            adapter.notifyItemInserted(todoList.size - 1)
            Toast.makeText(this@MainActivity, " '${etTodo.text}' has been Added to the List", Toast.LENGTH_SHORT).show()
            etTodo.text.clear()
        }
    }
}

/*
STEPS:
1. Create a new layout file for the referencing of each element in the recycler view, For ex: item_todo.xml
2. Now create a Adapter Class, for ex: TodoAdapter.kt , (helps in showing data).
3. Makes an Inner class inside adapter class which takes a view item as a constructor and inherits from RecyclerView.ViewHolder in
    which the constructor contains the same view item.
    Example: inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)\
4. Since we need to pass the type of data we need to pass in the adapter class, we create a new data class..!
5. After passing the data class as a form of list, we make it inherit RecyclerView.Adapter<VH>() just to show that this adapter is an RecyclerView adapter.
    The VH here will take the reference of inner class VIewHolder.
6. We have to override three functions accordingly.
7. After that come to MainAcitvity.kt file, here we have to do all the remaining works.
8.      val adapter = TodoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        THis above four lines is highly important, as this sets and binds all the work we do this far..
9. adapter.notifyItemInserted(todoList.size - 1) , this help in updation of the newly inserted item, thus recyclerview gets updated.!
 */