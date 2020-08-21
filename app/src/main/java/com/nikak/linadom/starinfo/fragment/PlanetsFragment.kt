package com.nikak.linadom.starinfo.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikak.linadom.starinfo.PlanetNamesAdapter

import com.nikak.linadom.starinfo.R
import com.nikak.linadom.starinfo.entity.Planet
import com.nikak.linadom.starinfo.service.PlanetViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PlanetsFragment : androidx.fragment.app.Fragment() {

    var page: Int = 1
    var limit: Int = 6

    private lateinit var recyclerView: RecyclerView
    private lateinit var namesAdapter: PlanetNamesAdapter


    private val BASE_URL = "https://swapi.dev/api/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.i("PlanetsFragment 1", "Я тут ")
        var view = inflater.inflate(R.layout.fragment_planets, container, false)


        recyclerView = view.findViewById(R.id.planet_names_RV) as RecyclerView

        var linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager

        //getting our ItemViewModel
        val planetViewModel = ViewModelProvider(this).get(PlanetViewModel::class.java)

        //creating the Adapter
        val adapter = PlanetNamesAdapter(this.context!!)
//observing the itemPagedList from view model


        planetViewModel.itemPagedList.observe(this,
            Observer<PagedList<Planet>> { planets ->
                //in case of any changes
                //submitting the items to adapter
                adapter.submitList(planets)
            })

        //setting the adapter
        recyclerView.adapter = adapter

        return view
    }
}
