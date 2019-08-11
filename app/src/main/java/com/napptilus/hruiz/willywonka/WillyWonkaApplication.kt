package com.napptilus.hruiz.willywonka

import android.app.Application
import com.napptilus.hruiz.willywonka.di.departmentModule
import com.napptilus.hruiz.willywonka.di.employeeDetailModule
import com.napptilus.hruiz.willywonka.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WillyWonkaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@WillyWonkaApplication)
            modules(listOf(networkModule, departmentModule, employeeDetailModule))
        }
    }
}