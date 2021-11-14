package com.example.todolist.Itemadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Datasource.DataSource
import com.example.todolist.R

class ItemAdapter(
    private val context: Context?
    ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val dataset = DataSource().tasks()


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context?.resources?.getString(item.date)
    }

    override fun getItemCount():Int{
     return dataset.size
    }

}
