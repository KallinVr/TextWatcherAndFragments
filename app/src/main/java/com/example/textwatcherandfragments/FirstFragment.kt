package com.example.textwatcherandfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {
    private var adapter: RecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
        adapter?.setData(insertData())
    }

    private fun insertData(): MutableList<Item?>{
        val list = mutableListOf<Item?>()

        list.add(ImageItem("banana","image"))
        list.add(TextItem("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed" +
                " do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim" +
                " ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip" +
                " ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate" +
                " velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat" +
                " cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est" +
                " laborum.","text"))
        list.add(ImageItem("apple","image"))
        list.add(TextItem("Hello", "text"))
        list.add(TextItem("World", "text"))
        return list
    }

}