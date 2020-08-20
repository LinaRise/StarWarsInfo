package com.nikak.linadom.starinfo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.nikak.linadom.starinfo.entity.Planet


class PlanetDataSourceFactory : DataSource.Factory<Int,Planet>() {

    //creating the mutable live data
    //getter for itemlivedatasource
    val itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Planet>>()

   override fun create(): DataSource<Int, Planet> {
        //getting our data source object
        val itemDataSource = PlanetDataSource()

        //posting the datasource to get the values
        itemLiveDataSource.postValue(itemDataSource)

        //returning the datasource
        return itemDataSource
    }
}