package com.nikak.linadom.starinfo


import android.content.ClipData
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikak.linadom.starinfo.entity.Model
import com.nikak.linadom.starinfo.entity.Planet
import com.nikak.linadom.starinfo.service.ApiService
import com.nikak.linadom.starinfo.service.PlanetViewModel
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

//class MainActivity : AppCompatActivity() {
//
//    //getting recyclerview
//    private var recyclerView: RecyclerView? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        //setting up recyclerview
//        recyclerView = findViewById(R.id.recyclerview)
//        recyclerView!!.layoutManager = LinearLayoutManager(this)
//        recyclerView!!.setHasFixedSize(true)
//
//        //getting our ItemViewModel
//        val itemViewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
//
//        //creating the Adapter
//        val adapter = ItemAdapter(this)
//
//
//        //observing the itemPagedList from view model
//        itemViewModel.itemPagedList.observe(this,
//            Observer<PagedList<Item>> { items ->
//                //in case of any changes
//                //submitting the items to adapter
//                adapter.submitList(items)
//            })
//
//        //setting the adapter
//        recyclerView!!.adapter = adapter
//    }
//}
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

//
//        getData(page, limit)


//        val api = retrofit.create(ApiService::class.java)
//        var planetsList = listOf<Planet>()
//        api.getAllPlanets().enqueue(object : Callback<Model> {
//            override fun onResponse(call: Call<Model>, response: Response<Model>) {
//                if (response.isSuccessful) {
//                    Log.i("onResponse!!!", "onResponse")
//                    applyAdapter(response.body()!!.planets!!)
////                    Log.i("onResponse1", planetsList[1].name)
//////                    planetsList.forEach {
//////                        print(it.name)
//////                    }
////                    Log.i("onResponse2", planetsList[0].name)
//                }
//                Log.i("CouldntGet!!!", "CouldntGet")
//            }
//
//            override fun onFailure(call: Call<Model>, t: Throwable) {
//                Log.e("Failure!!!", "onFailure")
//            }
//
//        })


// Inflate the layout for this fragment


//    private fun applyAdapter(list: List<Planet>) {
//        namesAdapter = NamesAdapter(list)
//        recyclerView?.adapter = namesAdapter
//    }


//    private fun getData(pageMin: Int, pageMax: Int) {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val client = OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//        var retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client.build())
//            .build()
//
//        val api = retrofit.create(ApiService::class.java)
////        var planetsList = listOf<Planet>()
//        var planetsList = listOf<Planet>()
//        api.getAllPlanets(pageMin, pageMax).enqueue(object : Callback<Model> {
//            override fun onResponse(call: Call<Model>, response: Response<Model>) {
//                if (response.isSuccessful) {
//                    Log.i("onResponse!!!", "onResponse")
//                    applyAdapter(response.body()!!.planets!!)
////                    Log.i("onResponse1", planetsList[1].name)
//////                    planetsList.forEach {
//////                        print(it.name)
//////                    }
////                    Log.i("onResponse2", planetsList[0].name)
//                }
//                Log.i("CouldntGet!!!", "CouldntGet")
//            }
//
//            override fun onFailure(call: Call<Model>, t: Throwable) {
//                Log.e("Failure!!!", "onFailure")
//            }
//
//        })
//
//    }
//
//
//}
