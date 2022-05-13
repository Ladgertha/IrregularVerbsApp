package ru.ladgertha.datastore_impl.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.ladgertha.datastore_api.datastore.IrregularVerbsDatastore
import ru.ladgertha.datastore_api.repository.IrregularVerbRepository
import ru.ladgertha.datastore_api.usecase.GetShowRareVerbsSettingsUseCase
import ru.ladgertha.datastore_api.usecase.SaveShowRareVerbsSettingsUseCase
import ru.ladgertha.datastore_impl.datastore.IrregularVerbsDatastoreImpl
import ru.ladgertha.datastore_impl.interactor.GetShowRareVerbsSettingsInteractor
import ru.ladgertha.datastore_impl.interactor.SaveShowRareVerbsSettingsInteractor
import ru.ladgertha.datastore_impl.repository.IrregularVerbRepositoryImpl

val dataStoreModule = module {

    single<IrregularVerbsDatastore> {
        IrregularVerbsDatastoreImpl(
            androidContext()
        )
    }

    factory<IrregularVerbRepository> {
        IrregularVerbRepositoryImpl(
            datastore = get() as IrregularVerbsDatastore
        )
    }

    factory<SaveShowRareVerbsSettingsUseCase> {
        SaveShowRareVerbsSettingsInteractor(
            repository = get() as IrregularVerbRepository
        )
    }

    factory<GetShowRareVerbsSettingsUseCase> {
        GetShowRareVerbsSettingsInteractor(
            repository = get() as IrregularVerbRepository
        )
    }
}