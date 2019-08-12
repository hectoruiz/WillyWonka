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

//    val progressBar: ProgressBar = this.progressBar
//
//    progressBar.visibility = View.VISIBLE
//
//    GlobalScope.launch(Dispatchers.Main) {
//        fetchAndShowUser() // fetch on IO thread
//    }
//
//    suspend fun fetchAndShowUser() {
//        val employeeDetail = employeeDetailRepository.getEmployeeDetail(4)
//        showUser(employeeDetail)
//    }
//
//
//    fun showUser(employeeDetail: EmployeeDetail?) {
//        progressBar.visibility = View.INVISIBLE
//
//        Log.d("RESULTADO", employeeDetail.toString())
//    }

}
