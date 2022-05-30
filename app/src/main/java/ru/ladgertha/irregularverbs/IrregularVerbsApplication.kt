package ru.ladgertha.irregularverbs

import android.app.Application
import com.facebook.stetho.Stetho
import ru.ladgertha.di.DiProvider

@Suppress("Unused")
class IrregularVerbsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
        initStetho()
    }

    private fun initDi() {
        DiProvider.buildDi(this)
    }

    private fun initStetho() {
        // TODO Move to debug build
        Stetho.initializeWithDefaults(this)
    }
}
