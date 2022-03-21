package ru.ladgertha.irregularverbs

import android.app.Application
import ru.ladgertha.di.DiProvider

@Suppress("Unused")
class IrregularVerbsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi(this)
    }

    private fun initDi(application: Application) {
        DiProvider.buildDi(application)
    }
}
