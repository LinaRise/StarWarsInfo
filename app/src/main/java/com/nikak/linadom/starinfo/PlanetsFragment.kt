package com.nikak.linadom.starinfo


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PlanetsFragment : androidx.fragment.app.Fragment() {

    private var namesList: RecyclerView? = null
    private lateinit var namesAdapter: NamesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("PlanetsFragment 1", "Я тут ")
        var view =  inflater.inflate(R.layout.fragment_planets, container, false)
        namesList =  view?.findViewById(R.id.planet_names_RV)  as? RecyclerView
        print(namesList.toString())
        var linearLayoutManager = LinearLayoutManager(context)
        namesList?.layoutManager = linearLayoutManager

        namesAdapter = NamesAdapter(10)
        namesList?.adapter = namesAdapter
        Log.i("PlanetsFragment 2", "Я тут ")
        // Inflate the layout for this fragment
      return view
    }


}
