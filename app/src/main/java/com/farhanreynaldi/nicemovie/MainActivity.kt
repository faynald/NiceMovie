package com.farhanreynaldi.nicemovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farhanreynaldi.nicemovie.home_presentation.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}