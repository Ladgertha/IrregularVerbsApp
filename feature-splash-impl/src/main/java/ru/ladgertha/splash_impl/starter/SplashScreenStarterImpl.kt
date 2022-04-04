package ru.ladgertha.splash_impl.starter

import androidx.appcompat.app.AppCompatActivity
import ru.ladgertha.splash_api.SplashScreenStarter
import ru.ladgertha.splash_impl.SplashScreenFragment

class SplashScreenStarterImpl(
    private val activity: AppCompatActivity
) : SplashScreenStarter {

    override fun start(containerViewId: Int) {
        if (activity.isFinishing || activity.isDestroyed) {
            return
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(containerViewId, SplashScreenFragment.newInstance())
            .commit()
    }
}