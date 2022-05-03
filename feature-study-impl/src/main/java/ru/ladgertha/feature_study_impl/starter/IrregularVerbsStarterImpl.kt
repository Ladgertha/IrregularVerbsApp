package ru.ladgertha.feature_study_impl.starter

import androidx.appcompat.app.AppCompatActivity
import ru.ladgertha.feature_study_api.IrregularVerbsStarter
import ru.ladgertha.feature_study_impl.IrregularVerbsFragment

class IrregularVerbsStarterImpl(
    private val activity: AppCompatActivity
) : IrregularVerbsStarter {

    override fun start(containerViewId: Int) {
        if (activity.isFinishing || activity.isDestroyed) {
            return
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(containerViewId, IrregularVerbsFragment.newInstance())
            .commit()
    }
}