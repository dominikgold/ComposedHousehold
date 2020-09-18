package com.dominikgold.household

import android.app.Application
import com.dominikgold.household.di.AppComponent
import com.dominikgold.household.di.DaggerAppComponent

class HouseholdApplication : Application() {

    lateinit var daggerAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}