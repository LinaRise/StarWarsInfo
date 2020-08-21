package com.nikak.linadom.starinfo


import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nikak.linadom.starinfo.entity.Planet
import android.content.ClipData.Item
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.nikak.linadom.starinfo.fragment.PlanetInfoFragment
import com.nikak.linadom.starinfo.fragment.PlanetsFragment
import androidx.core.content.ContextCompat.startActivity


class PlanetNamesAdapter internal constructor(private val mCtx: Context) :

    PagedListAdapter<Planet, PlanetNamesAdapter.PlanetNameViewHolder>(DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: PlanetNameViewHolder, position: Int) {
        val planet = getItem(position)

        if (planet != null) {
//            holder.listItemNameView.text = position.toString()
            holder.viewHolderIndex.text = planet.name

            val onCardViewSelectedListener = View.OnClickListener {
                val intent = Intent(it.context, PlanetInfoActivity::class.java)
                intent.putExtra("planetInfo", planet)
                it.context.startActivity(intent)

//                Toast.makeText(mCtx, planet.name,Toast.LENGTH_SHORT).show()
//                val appCompatActivity = mCtx as AppCompatActivity
//                val planetInfoFragment = PlanetInfoFragment()
//                appCompatActivity.supportFragmentManager
//                    .beginTransaction()
//                    .add(R.id.frameLayout_cv,planetInfoFragment)
//
//                    .addToBackStack(null)
//                    .commit()
            }
            holder.cardView.setOnClickListener(onCardViewSelectedListener)


        } else {
            Toast.makeText(mCtx, "Planet is null", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetNameViewHolder {
        val context = parent.context
        val layoutIdForListItem = R.layout.name_list_item
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(layoutIdForListItem, parent, false)
        val viewHolder = PlanetNameViewHolder(view)


        return viewHolder

    }


    inner class PlanetNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //        var listItemNameView: TextView = itemView.findViewById(R.id.name_item_tv)
        var cardView: CardView = itemView.findViewById(R.id.cv)
        var viewHolderIndex: TextView = itemView.findViewById(R.id.view_holder_name_tv)


//        fun bind(listIndex: Int) {
//            listItemNameView.text = listIndex.toString()
//            viewHolderIndex.text = planetsList[listIndex].name
//
//        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Planet>() {
            override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return oldItem.name === newItem.name
            }

            override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return oldItem == newItem
            }
        }
    }
}
//class NamesAdapter(private val planetsList: List<Planet>) : PagedListAdapter<Planet, NamesAdapter.NumberViewHolder>() {
//
//    init {
//        viewHolderCount = 0
//    }
//
//
//    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
//        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
//            return oldItem.question_id === newItem.question_id
//        }
//
//        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesAdapter.NumberViewHolder {
//        val context = parent.context
//        val layoutIdForListItem = R.layout.name_list_item
//        val inflater = LayoutInflater.from(context)
//        val view = inflater.inflate(layoutIdForListItem, parent, false)
//        val viewHolder = NumberViewHolder(view)
////        viewHolder.viewHolderIndex.text = "ViewHolder $viewHolderCount"
//        viewHolderCount++
//        return viewHolder
//    }
//
//
//    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
//        holder.bind(position)
//    }
//
//    override fun getItemCount(): Int {
//        return planetsList.size
//    }
//
//    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var listItemNameView: TextView = itemView.findViewById(R.id.name_item_tv)
//        var viewHolderIndex: TextView = itemView.findViewById(R.id.view_holder_number_tv)
//
//        fun bind(listIndex: Int) {
//            listItemNameView.text = listIndex.toString()
//            viewHolderIndex.text = planetsList[listIndex].name
//
//        }
//    }
//
//    companion object {
//        //
//        private var viewHolderCount: Int = 0
//    }
//}

//class NamesAdapter(private val planetsList: List<Planet>) : RecyclerView.Adapter<NamesAdapter.NumberViewHolder>() {
//
//    init {
//        viewHolderCount = 0
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
//        val context = parent.context
//        val layoutIdForListItem = R.layout.name_list_item
//        val inflater = LayoutInflater.from(context)
//        val view = inflater.inflate(layoutIdForListItem, parent, false)
//        val viewHolder = NumberViewHolder(view)
////        viewHolder.viewHolderIndex.text = "ViewHolder $viewHolderCount"
//        viewHolderCount++
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
//        holder.bind(position)
//    }
//
//    override fun getItemCount(): Int {
//        return planetsList.size
//    }
//
//    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var listItemNameView: TextView = itemView.findViewById(R.id.name_item_tv)
//        var viewHolderIndex: TextView = itemView.findViewById(R.id.view_holder_number_tv)
//
//        fun bind(listIndex: Int) {
//            listItemNameView.text = listIndex.toString()
//            viewHolderIndex.text = planetsList[listIndex].name
//
//        }
//    }
//
//
//    companion object {
//
//        private var viewHolderCount: Int = 0
//    }
//}
//
