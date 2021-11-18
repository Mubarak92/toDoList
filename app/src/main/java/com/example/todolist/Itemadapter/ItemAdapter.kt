package com.example.todolist.Itemadapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Datasource.DataSource
import com.example.todolist.Datasource.deleteTask
import com.example.todolist.Datasource.tasklist
import com.example.todolist.ListsFragment
import com.example.todolist.ListsFragmentDirections
import com.example.todolist.R
import com.example.todolist.tasksData
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*

class ItemAdapter(

    private val context: Context?,
private val dataset:List<tasksData>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

//    private val dataset = DataSource().tasks()


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var titalTask: TextView = view.findViewById(R.id.TaskTitle)
        var descript: TextView = view.findViewById(R.id.Discript)
        var date: TextView = view.findViewById(R.id.date)

var isdone: ImageView = view.findViewById(R.id.isDone)
        var titlebutton: Button = view.findViewById(R.id.TaskTitle)
        val delete: Button = view.findViewById(R.id.deletebtn)
        // val add: Button = view.findViewById(R.id.add_task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)

    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]




        if (item.setdate.toString() != ""){
            val nowDate = Date()
            val formatter = SimpleDateFormat("dd/MM/yyyy")
            val tasktime = formatter.parse(item.setdate.toString())
            if (nowDate.after(tasktime)) {
                holder.isdone.visibility = View.VISIBLE
            }
        }

        holder.titlebutton.setOnClickListener {
            val action = ListsFragmentDirections.actionListsFragmentToEditFragment()
            holder.itemView.findNavController().navigate(action)
        }

        holder.titalTask.text = item.titalTask
        holder.descript.text = item.descriptText
        holder.date.text = item.setdate
        holder.delete.setOnClickListener {
//Toast.makeText(holder.itemView.context,"ttt",Toast.LENGTH_SHORT).show()
                       deleteTask(item.titalTask.toString())
                        notifyDataSetChanged()
        }


}

override fun getItemCount(): Int {
    return dataset.size
}

}

