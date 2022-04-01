package ru.ladgertha.irregularverbs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import ru.ladgertha.irregularverbs.R
import ru.ladgertha.splash_api.SplashScreenStarter

class IrregularVerbsActivity : AppCompatActivity() {

    private val splashScreenStarter: SplashScreenStarter by inject {
        parametersOf(this@IrregularVerbsActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irregular_verbs)
        if (savedInstanceState == null) {
            splashScreenStarter.start(R.id.irregularVerbsContainer)
        }
    }
}