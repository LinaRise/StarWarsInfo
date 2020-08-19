package com.nikak.linadom.starinfo.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Planet (

    @SerializedName("name")
    @Expose
    var name: String? ,
    @SerializedName("rotation_period")
    @Expose
    var rotationPeriod: String? ,
    @SerializedName("orbital_period")
    @Expose
    var orbitalPeriod: String? ,
    @SerializedName("diameter")
    @Expose
    var diameter: String? ,
    @SerializedName("climate")
    @Expose
    var climate: String? ,
    @SerializedName("gravity")
    @Expose
    var gravity: String? ,
    @SerializedName("terrain")
    @Expose
    var terrain: String? ,
    @SerializedName("surface_water")
    @Expose
    var surfaceWater: String? ,
    @SerializedName("population")
    @Expose
    var population: String? ,
    @SerializedName("residents")
    @Expose
    var residents: List<String>? ,
    @SerializedName("films")
    @Expose
    var films: List<String>? ,
    @SerializedName("created")
    @Expose
    var created: String? ,
    @SerializedName("edited")
    @Expose
    var edited: String? ,
    @SerializedName("url")
    @Expose
    var url: String?

)