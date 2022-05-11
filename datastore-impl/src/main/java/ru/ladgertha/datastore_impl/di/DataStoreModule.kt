package ru.ladgertha.datastore_impl.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.ladgertha.datastore_api.IrregularVerbsDatastore
import ru.ladgertha.datastore_impl.IrregularVerbsDatastoreImpl

val dataStoreModule = module {

    single<IrregularVerbsDatastore> {
        IrregularVerbsDatastoreImpl(
            androidContext()
        )
    }
}