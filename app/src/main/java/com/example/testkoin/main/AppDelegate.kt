package com.example.testkoin.main

import android.app.Application
import com.example.testkoin.di.ApplicationModule
import com.example.testkoin.di.RetrofitService
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppDelegate)
            androidFileProperties()
            koin.loadModules(// module list
                    listOf(
                            ApplicationModule.applicationModule,
                            RetrofitService.retrofitService))
        }
    }
}