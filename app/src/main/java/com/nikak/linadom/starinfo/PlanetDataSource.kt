package com.nikak.linadom.starinfo

import android.content.ClipData.Item
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.util.Log
import android.view.Display
import androidx.annotation.NonNull
import androidx.paging.PageKeyedDataSource
import com.nikak.linadom.starinfo.entity.Model
import com.nikak.linadom.starinfo.entity.Planet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlanetDataSource : PageKeyedDataSource<Int, Planet>() {


    //this will be called once to load the initial data
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Planet>) {
        RetrofitClient.instance.api.getAllPlanets(FIRST_PAGE)
            .enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    if (response.body() != null) {
                        callback.onResult(response.body()!!.planets!!, null, FIRST_PAGE + 1);
                    }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Log.e("loadInitial", "onFailure")
                }
            })
    }

    //this will load the previous page
    override fun loadBefore(
        params: PageKeyedDataSource.LoadParams<Int>,
        callback: PageKeyedDataSource.LoadCallback<Int, Planet>
    ) {
        RetrofitClient.instance.api.getAllPlanets(params.key)
            .enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {

                    //if the current page is greater than one
                    //we are decrementing the page number
                    //else there is no previous page
                    val adjacentKey = if (params.key > 1) params.key - 1 else null
                    if (response.body() != null) {

                        //passing the loaded data
                        //and the previous page key
                        callback.onResult(response.body()?.planets!!, adjacentKey)
                    }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Log.e("loadBefore", "onFailure")
                }
            })
    }

    //this will load the next page
    override fun loadAfter(
        params: PageKeyedDataSource.LoadParams<Int>,
        callback: PageKeyedDataSource.LoadCallback<Int, Planet>
    ) {
        RetrofitClient.instance.api.getAllPlanets(params.key)
            .enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {

                    if (response.body() != null) {
                        //if the response has next page
                        //incrementing the next page number
                        val key = if (response.body()!!.next != null) params.key + 1 else null

                        //passing the loaded data and next page value
                        callback.onResult(response.body()?.planets!!, key)
                    }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Log.e("loadAfter", "onFailure")
                }
            })
    }

    companion object {

        //the size of a page that we want
        val PAGE_SIZE = 10

        //we will start from the first page which is 1
        private val FIRST_PAGE = 1
        //we need to fetch from stackoverflow
        private val SITE_NAME = "stackoverflow"
    }
}