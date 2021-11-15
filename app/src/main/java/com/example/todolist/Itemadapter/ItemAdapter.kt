package com.example.todolist.Itemadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Datasource.DataSource
import com.example.todolist.ListsFragment
import com.example.todolist.R

class ItemAdapter(
    private val context: ListsFragment,
    context1: Context?,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val dataset = DataSource().tasks()


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.TaskTitle)
        val textView2: TextView = view.findViewById(R.id.Discript)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        //holder.textView.text = context.resources.getString(item.titalTask)
       // holder.textView2.text = context.resources.getString(item.descriptText)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}

