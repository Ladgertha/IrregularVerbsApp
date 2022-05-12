package ru.ladgertha.datastore_impl.repository

import kotlinx.coroutines.flow.Flow
import ru.ladgertha.datastore_api.datastore.IrregularVerbsDatastore
import ru.ladgertha.datastore_api.repository.IrregularVerbRepository

class IrregularVerbRepositoryImpl(
    private val datastore: IrregularVerbsDatastore
): IrregularVerbRepository {

    override suspend fun saveShowRareVerbsSettings(showRareVerbs: Boolean) {
        datastore.saveShowRareVerbsSettings(showRareVerbs)
    }

    override fun showRareVerbsSettings(): Flow<Boolean> {
        return datastore.showRareVerbsSettings()
    }
}