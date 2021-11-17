package com.example.todolist.Itemadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Datasource.DataSource
import com.example.todolist.ListsFragment
import com.example.todolist.ListsFragmentDirections
import com.example.todolist.R

class ItemAdapter(
    context1: ListsFragment,
    private val context: Context?,

    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val dataset = DataSource().tasks()


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titalTask: TextView = view.findViewById(R.id.TaskTitle)
        val descrit: TextView = view.findViewById(R.id.Discript55)
        val titlebutton : Button = view.findViewById(R.id.TaskTitle)
val delete: ImageView= view.findViewById(R.id.deleteimage)
       // val add: Button = view.findViewById(R.id.add_task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.delete.setOnClickListener{

        }
        holder.titlebutton.setOnClickListener{
            val action = ListsFragmentDirections.actionListsFragmentToEditFragment()
            holder.itemView.findNavController().navigate(action)
        }
        holder.titalTask.text = item.titalTask.toString()
        holder.descrit.text = item.descriptText.toString()

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}

