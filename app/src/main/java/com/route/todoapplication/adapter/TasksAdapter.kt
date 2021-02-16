package com.route.todoapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.todoapplication.R
import com.route.todoapplication.database.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TasksAdapter(var tasks:List<Task>)
    :RecyclerView.Adapter<TasksAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = tasks.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks.get(position)
        holder.title.setText(task.title)
        holder.isCompleted.isChecked = task.isCompleted?:false
    }

    fun changeData(tasksList: List<Task>) {
        tasks = tasksList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val title = itemView.title
        val isCompleted = itemView.isCompleted
    }

}