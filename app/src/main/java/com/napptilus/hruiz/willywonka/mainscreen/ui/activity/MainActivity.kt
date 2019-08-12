package com.napptilus.hruiz.willywonka.mainscreen.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.napptilus.hruiz.willywonka.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val host = NavHostFragment.create(R.navigation.navigation_graph)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, host).setPrimaryNavigationFragment(host)
                .commit()
        }
    }
}
