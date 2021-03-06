package com.example.testkoin.view.viewMode

import android.app.Application
import com.example.testkoin.dependancy.ApplicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class AppDelegate: Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@AppDelegate)
            androidFileProperties()
            koin.loadModules(// module list
                listOf(ApplicationModule.applicationModule))
        }
    }
}