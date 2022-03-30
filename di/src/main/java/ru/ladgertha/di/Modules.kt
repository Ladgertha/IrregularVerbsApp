package ru.ladgertha.di

import org.koin.core.module.Module
import ru.ladgertha.di.modules.lockModule
import ru.ladgertha.feature_study_impl.di.irregularVerbsModule

val appModules = mutableListOf<Module>(
    irregularVerbsModule,
    lockModule
)
