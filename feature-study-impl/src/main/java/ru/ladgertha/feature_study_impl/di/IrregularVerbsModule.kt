package ru.ladgertha.feature_study_impl.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ladgertha.feature_study_impl.IrregularVerbsViewModel

val irregularVerbsModule = module {

    viewModel {
        IrregularVerbsViewModel()
    }
}