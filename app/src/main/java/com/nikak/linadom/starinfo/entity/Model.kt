package com.nikak.linadom.starinfo.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Model (

    @SerializedName("count")
    @Expose
    var count: Int? ,
    @SerializedName("next")
    @Expose
    var next: String? ,
    @SerializedName("previous")
    @Expose
    var previous: Any? ,
    @SerializedName("results")
    @Expose
    var planets: List<Planet>?

)