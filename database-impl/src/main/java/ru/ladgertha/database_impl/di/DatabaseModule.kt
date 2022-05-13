package ru.ladgertha.database_impl.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ru.ladgertha.database_api.IrregularVerbsDataStore
import ru.ladgertha.database_api.IrregularVerbsRepository
import ru.ladgertha.database_api.usecase.GetNextVerbUseCase
import ru.ladgertha.database_api.usecase.InsertIrregularVerbsUseCase
import ru.ladgertha.database_api.usecase.IsDatabaseEmptyUseCase
import ru.ladgertha.database_impl.converter.IrregularVerbsFromJsonConverter
import ru.ladgertha.database_impl.database.IStorageDatabase
import ru.ladgertha.database_impl.database.StorageDatabase
import ru.ladgertha.database_impl.datastore.IrregularVerbsDataStoreImpl
import ru.ladgertha.database_impl.interactor.GetNextVerbInteractor
import ru.ladgertha.database_impl.interactor.InsertIrregularVerbsInteractor
import ru.ladgertha.database_impl.interactor.IsDatabaseEmptyInteractor
import ru.ladgertha.database_impl.repository.IrregularVerbsRepositoryImpl

val databaseModule = module {

    factory<InsertIrregularVerbsUseCase> {
        InsertIrregularVerbsInteractor(
            irregularVerbsRepository = get() as IrregularVerbsRepository,
            irregularVerbsFromJsonConverter = get() as IrregularVerbsFromJsonConverter
        )
    }

    factory<IsDatabaseEmptyUseCase> {
        IsDatabaseEmptyInteractor(
            irregularVerbsRepository = get() as IrregularVerbsRepository
        )
    }

    factory<GetNextVerbUseCase> {
        GetNextVerbInteractor(
            repository = get() as IrregularVerbsRepository
        )
    }

    single<IrregularVerbsRepository> {
        IrregularVerbsRepositoryImpl(
            irregularVerbsDataStore = get() as IrregularVerbsDataStore
        )
    }

    single<IrregularVerbsDataStore> {
        IrregularVerbsDataStoreImpl(
            storageDao = (get() as IStorageDatabase).irregularVerbDao()
        )
    }

    single<IStorageDatabase> { StorageDatabase.getInstance(androidApplication()) }

    single<IrregularVerbsFromJsonConverter> { IrregularVerbsFromJsonConverter(androidApplication()) }
}