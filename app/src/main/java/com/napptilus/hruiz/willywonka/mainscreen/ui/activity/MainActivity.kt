package com.napptilus.hruiz.willywonka.mainscreen.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.napptilus.hruiz.willywonka.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Log.d("MainActivity", "HelloWorld!")
    }
}