package com.marco.pocandroidtvleanback

import android.app.Application
import com.marco.pocandroidtvleanback.core.di.dataModule
import com.marco.pocandroidtvleanback.core.di.dataRemoteModule
import com.marco.pocandroidtvleanback.core.di.presentationModule
import com.marco.pocandroidtvleanback.core.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                //  intentModule +
                listOf(
                    dataModule,
                    dataRemoteModule,
                    useCaseModule,
                    presentationModule
                )
            )
        }
    }
}