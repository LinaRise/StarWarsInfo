package com.nikak.linadom.starinfo.service

import androidx.paging.LivePagedListBuilder
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.PagedList
import android.content.ClipData.Item
import androidx.paging.PageKeyedDataSource
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nikak.linadom.starinfo.PlanetDataSource
import com.nikak.linadom.starinfo.PlanetDataSourceFactory
import com.nikak.linadom.starinfo.entity.Planet


class PlanetViewModel : ViewModel() {

    //creating livedata for PagedList  and PagedKeyedDataSource
    internal var itemPagedList: LiveData<PagedList<Planet>>
    internal var liveDataSource: LiveData<PageKeyedDataSource<Int, Planet>>

    //constructor
    init {
        //getting our data source factory
        val planetDataSourceFactory = PlanetDataSourceFactory()

        //getting the live data source from data source factory
        liveDataSource = planetDataSourceFactory.itemLiveDataSource

        //Getting PagedList config
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PlanetDataSource.PAGE_SIZE).build()

        //Building the paged list
        itemPagedList = LivePagedListBuilder(planetDataSourceFactory, pagedListConfig)
            .build()
    }
}