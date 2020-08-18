package com.nikak.linadom.starinfo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NamesAdapter(private val numberItems: Int) : RecyclerView.Adapter<NamesAdapter.NumberViewHolder>() {

    init {
        viewHolderCount = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val context = parent.context
        val layoutIdForListItem = R.layout.name_list_item
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(layoutIdForListItem, parent, false)
        val viewHolder = NumberViewHolder(view)
        viewHolder.viewHolderIndex.text = "ViewHolder $viewHolderCount"
        viewHolderCount++
        return viewHolder
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return numberItems
    }

    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listItemNameView: TextView = itemView.findViewById(R.id.name_item_tv)
        var viewHolderIndex: TextView = itemView.findViewById(R.id.view_holder_number_tv)

        fun bind(listIndex: Int) {
            listItemNameView.text = listIndex.toString()
        }
    }

    companion object {

        private var viewHolderCount: Int = 0
    }
}

