package ru.ladgertha.irregularverbs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import ru.ladgertha.feature_study_api.IrregularVerbsStarter
import ru.ladgertha.irregularverbs.R

class IrregularVerbsActivity : AppCompatActivity() {

    private val irregularVerbsStarter: IrregularVerbsStarter by inject {
        parametersOf(this@IrregularVerbsActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irregular_verbs)
        if (savedInstanceState == null) {
            irregularVerbsStarter.start(R.id.irregularVerbsContainer)
        }
    }
}