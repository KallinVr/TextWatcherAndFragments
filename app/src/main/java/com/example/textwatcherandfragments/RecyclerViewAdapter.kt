package com.example.textwatcherandfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val VIEW_TYPE_IMAGE = 1
        const val VIEW_TYPE_TEXT = 2
    }

    private var itemList : MutableList<Item?> = mutableListOf()

    fun setData(items: MutableList<Item?>){
        itemList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return when(viewType){
            VIEW_TYPE_IMAGE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_item,parent,false)
                HeaderViewHolder(view)
            }
            VIEW_TYPE_TEXT -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.text_item,parent,false)
                ContentViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_item,parent,false)
                HeaderViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pos = itemList.get(position)

        when(getItemViewType(position)){
            VIEW_TYPE_IMAGE -> {
                (holder as HeaderViewHolder).bind(pos)
            }
            VIEW_TYPE_TEXT -> {
                (holder as ContentViewHolder).bind(pos)
            }
        }
    }

    inner class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageItemView: ImageView = itemView.findViewById(R.id.imageView)
        fun bind(pos: Item?){
            if (pos?.name.equals("apple"))
                imageItemView.setImageResource(R.drawable.apple)
        }

    }

    inner class ContentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val textItemView: TextView = itemView.findViewById(R.id.text_item_text_view)

        fun bind(pos: Item?){
            textItemView.text = pos?.name
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        val type = itemList.get(position)?.viewType
        if (type == "image"){
            return VIEW_TYPE_IMAGE
        }
        return VIEW_TYPE_TEXT
    }
}