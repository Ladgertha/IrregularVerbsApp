package ru.ladgertha.splash_impl.di

import androidx.appcompat.app.AppCompatActivity
import org.koin.dsl.module
import ru.ladgertha.splash_api.SplashScreenStarter
import ru.ladgertha.splash_impl.starter.SplashScreenStarterImpl

val splashScreenModule = module {

    factory<SplashScreenStarter> { (activity: AppCompatActivity) ->
        SplashScreenStarterImpl(
            activity
        )
    }
}