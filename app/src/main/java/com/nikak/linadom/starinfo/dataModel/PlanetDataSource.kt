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

//PageKeyedDataSource - так как нам нужно предосталять номер страницы для получения данных
//то есть здаесь номер старницы становится ключом нашей старнцицы
class PlanetDataSource : PageKeyedDataSource<Int, Planet>() {


    //вывзвается 1 раз для загрузки первой страницы
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

    //загрузка предыдущей страницы
    override fun loadBefore(
        params: PageKeyedDataSource.LoadParams<Int>,
        callback: PageKeyedDataSource.LoadCallback<Int, Planet>
    ) {
        RetrofitClient.instance.api.getAllPlanets(params.key)
            .enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {

                    //если текущая траница больше 1
                   // то уменьшаем текущую страницу на 1
                    val adjacentKey = if (params.key > 1) params.key - 1 else null
                    if (response.body() != null) {

                       //отдаем инфу и ключ предыдущей страницы
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
                        //если есть следующая стрница, то ув ключ на 1
                        val key = if (response.body()!!.next != null) params.key + 1 else null

                     //передаме данные и новый ключ
                        callback.onResult(response.body()?.planets!!, key)
                    }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Log.e("loadAfter", "onFailure")
                }
            })
    }

    companion object {

        //сколько хотим на странице отображать
        val PAGE_SIZE = 10

        //первая сттраница
        private val FIRST_PAGE = 1

    }
}