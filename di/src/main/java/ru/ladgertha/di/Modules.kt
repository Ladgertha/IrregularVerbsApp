package ru.ladgertha.di

import org.koin.core.module.Module
import ru.ladgertha.database_impl.di.databaseModule
import ru.ladgertha.di.modules.lockModule
import ru.ladgertha.feature_study_impl.di.irregularVerbsModule
import ru.ladgertha.splash_impl.di.splashScreenModule

val appModules = mutableListOf<Module>(
    irregularVerbsModule,
    lockModule,
    splashScreenModule,
    databaseModule
)
