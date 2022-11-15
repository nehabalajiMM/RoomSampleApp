package com.example.roomsampleapp

import android.app.Application
import com.example.roomsampleapp.di.AppComponent
import com.example.roomsampleapp.di.DaggerAppComponent

class RoomSampleApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
