package com.nikak.linadom.starinfo

import com.nikak.linadom.starinfo.service.ApiService
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class RetrofitClient private constructor() {
    private val retrofit: Retrofit

    val api: ApiService
        get() = retrofit.create(ApiService::class.java)


    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {

        private val BASE_URL = "https://swapi.dev/api/"
        private var mInstance: RetrofitClient? = null

        val instance: RetrofitClient
            @Synchronized get() {
                if (mInstance == null) {
                    mInstance = RetrofitClient()
                }
                return mInstance as RetrofitClient
            }
    }
}
//class NetService() : Retrofit() {
//
//    var retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//
//    companion object {
//        private val BASE_URL = "https://swapi.dev/api/"
//
//
//    }
//}

//In this case, The by lazy{}indicates it will be computed on the first access only.
// The evaluation of lazy properties is synchronized,
// the value is computed only in one thread, and all threads will see the same value.


//class NetService private constructor() {
//    private val mRetrofit: Retrofit
//
//    init {
//        mRetrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    companion object {
//        private var netService: NetService? = null
//        private val BASE_URL = "https://swapi.dev/api/"
//
//        val instance: NetService
//            get() {
//                if (netService == null) {
//                    netService = NetService()
//                }
//                return netService as NetService
//            }
//    }
//
//
//}