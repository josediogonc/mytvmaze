package com.example.mytvmaze

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.example.mytvmaze.di.koin.CoreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MainApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    CoreModule
                )
            )
        }
    }

}