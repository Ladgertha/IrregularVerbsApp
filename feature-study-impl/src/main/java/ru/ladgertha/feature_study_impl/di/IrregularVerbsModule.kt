package ru.ladgertha.feature_study_impl.di

import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ladgertha.database_api.usecase.GetNextVerbUseCase
import ru.ladgertha.database_api.usecase.InsertIrregularVerbsUseCase
import ru.ladgertha.database_api.usecase.IsDatabaseEmptyUseCase
import ru.ladgertha.datastore_api.usecase.GetShowRareVerbsSettingsUseCase
import ru.ladgertha.datastore_api.usecase.SaveShowRareVerbsSettingsUseCase
import ru.ladgertha.feature_study_api.IrregularVerbsStarter
import ru.ladgertha.feature_study_impl.IrregularVerbsViewModel
import ru.ladgertha.feature_study_impl.starter.IrregularVerbsStarterImpl

val irregularVerbsModule = module {

    viewModel {
        IrregularVerbsViewModel(
            isDatabaseEmptyUseCase = get() as IsDatabaseEmptyUseCase,
            insertIrregularVerbsUseCase = get() as InsertIrregularVerbsUseCase,
            getNextVerbUseCase = get() as GetNextVerbUseCase,
            saveShowRareVerbsSettingsUseCase = get() as SaveShowRareVerbsSettingsUseCase,
            getShowRareVerbsSettingsUseCase = get() as GetShowRareVerbsSettingsUseCase
        )
    }

    factory<IrregularVerbsStarter> { (activity: AppCompatActivity) ->
        IrregularVerbsStarterImpl(
            activity
        )
    }
}