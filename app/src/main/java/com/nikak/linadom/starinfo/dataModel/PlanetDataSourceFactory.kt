package com.nikak.linadom.starinfo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.nikak.linadom.starinfo.entity.Planet


class PlanetDataSourceFactory : DataSource.Factory<Int,Planet>() {

    //создаем the mutable live data
    val itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Planet>>()

   override fun create(): DataSource<Int, Planet> {
        //получае наш объект
        val itemDataSource = PlanetDataSource()
        itemLiveDataSource.postValue(itemDataSource)
        return itemDataSource
    }
}