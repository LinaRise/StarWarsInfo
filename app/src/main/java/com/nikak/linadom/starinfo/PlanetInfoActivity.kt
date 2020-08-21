package com.nikak.linadom.starinfo

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nikak.linadom.starinfo.entity.Planet

class PlanetInfoActivity : AppCompatActivity() {


    lateinit var planetName: TextView
    lateinit var rotationPeriod: TextView
    lateinit var orbitalPeriod: TextView
    lateinit var diameter: TextView
    lateinit var climate: TextView
    lateinit var gravity: TextView
    lateinit var terrain: TextView
    lateinit var surfaceWater: TextView
    lateinit var population: TextView
    lateinit var residents: TextView
    lateinit var films: TextView
    lateinit var created: TextView
    lateinit var edited: TextView
    lateinit var url: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_info)

        var planet = intent.getSerializableExtra("planetInfo") as Planet
        print(
            "planet ${planet.residents}"
        )
        planetName = findViewById(R.id.planet_name_tv)
        rotationPeriod = findViewById(R.id.rotationPeriod_tv)
        orbitalPeriod = findViewById(R.id.orbitalPeriod_tv)
        diameter = findViewById(R.id.diameter_tv)
        climate = findViewById(R.id.climate_tv)
        gravity = findViewById(R.id.gravity_tv)
        terrain = findViewById(R.id.terrain_tv)
        surfaceWater = findViewById(R.id.surfaceWater_tv)
        population = findViewById(R.id.population_tv)
        residents = findViewById(R.id.residents_tv)
        films = findViewById(R.id.films_tv)
        created = findViewById(R.id.created_tv)
        edited = findViewById(R.id.edited_tv)
        url = findViewById(R.id.url_tv)
        url.movementMethod = LinkMovementMethod.getInstance()
        url.setLinkTextColor(Color.BLUE)

        planetName.text = planet.name
        rotationPeriod.text = planet.rotationPeriod
        orbitalPeriod.text = planet.orbitalPeriod
        diameter.text = planet.diameter
        climate.text = planet.climate
        gravity.text = planet.gravity
        terrain.text = planet.terrain
        surfaceWater.text = planet.surfaceWater
        population.text = planet.population
        created.text = planet.created
        edited.text = planet.edited
        url.text = planet.url


    }
}
