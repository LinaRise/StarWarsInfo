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

    //создаем livedata для PagedList  and PagedKeyedDataSource
    internal var itemPagedList: LiveData<PagedList<Planet>>
    internal var liveDataSource: LiveData<PageKeyedDataSource<Int, Planet>>


    init {
        //инициализируем data source factory
        val planetDataSourceFactory = PlanetDataSourceFactory()

        //получаем live data source из data source factory
        liveDataSource = planetDataSourceFactory.itemLiveDataSource

        //настройки PagedList
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PlanetDataSource.PAGE_SIZE).build()

        //создаем PagedList
        itemPagedList = LivePagedListBuilder(planetDataSourceFactory, pagedListConfig)
            .build()
    }
}