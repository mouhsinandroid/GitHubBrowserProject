package com.mouhsinbr.android.githubbrowserproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mouhsinbr.android.githubbrowserproject.home.HomeFragment
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.screen_container, HomeFragment())
                .commit()
        }
    }
}