package ru.ladgertha.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object DiProvider {

    fun buildDi(application: Application) {
        startKoin {
            androidContext(application)
            koin.loadModules(appModules)
        }
    }
}
