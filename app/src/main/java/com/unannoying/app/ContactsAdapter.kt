package com.unannoying.app


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by amutha_c on 28,July,2023
 */
class ContactsAdapter(private val mList: List<Contacts>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_contacts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val listData = mList[position]
        holder.textView.text = listData.contactNo
        holder.time.text = listData.time
//        holder.layout.setOnClickListener {
//           Log.i("TAG","selected : $listData")
//        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.contact_no)
        val time: TextView = itemView.findViewById(R.id.time)
    }

    open class OnClickListener(val clickListener: (name: String) -> Unit) {
        fun onClick(name: String) = clickListener(name)
    }
}