package com.nikak.linadom.starinfo


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikak.linadom.starinfo.entity.Model
import com.nikak.linadom.starinfo.entity.Planet
import com.nikak.linadom.starinfo.service.ApiService
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient


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

    private val BASE_URL = "https://swapi.dev/api/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("PlanetsFragment 1", "Я тут ")
        var view = inflater.inflate(R.layout.fragment_planets, container, false)
        namesList = view?.findViewById(R.id.planet_names_RV)  as? RecyclerView
        print(namesList.toString())
        var linearLayoutManager = LinearLayoutManager(context)
        namesList?.layoutManager = linearLayoutManager


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
        val api = retrofit.create(ApiService::class.java)
        var planetsList = listOf<Planet>()
        api.getAllPlanets().enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful) {
                    Log.i("onResponse!!!", "onResponse")
                    applyAdapter(response.body()!!.planets!!)
//                    Log.i("onResponse1", planetsList[1].name)
////                    planetsList.forEach {
////                        print(it.name)
////                    }
//                    Log.i("onResponse2", planetsList[0].name)
                }
                Log.i("CouldntGet!!!", "CouldntGet")
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("Failure!!!", "onFailure")
            }

        })

        // Inflate the layout for this fragment
        return view
    }


   private fun applyAdapter( list:List<Planet>){
       namesAdapter = NamesAdapter(list)
       namesList?.adapter = namesAdapter
    }


}
