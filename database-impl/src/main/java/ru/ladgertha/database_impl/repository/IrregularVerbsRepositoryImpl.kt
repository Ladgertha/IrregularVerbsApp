package ru.ladgertha.database_impl.repository

import ru.ladgertha.database_api.IrregularVerb
import ru.ladgertha.database_api.IrregularVerbsDataStore
import ru.ladgertha.database_api.IrregularVerbsRepository

class IrregularVerbsRepositoryImpl(
    private val irregularVerbsDataStore: IrregularVerbsDataStore
): IrregularVerbsRepository {

    override fun insert(irregularVerbs: List<IrregularVerb>): Boolean {
        return irregularVerbsDataStore.insert(irregularVerbs)
    }

    override fun isDatabaseEmpty(): Boolean {
        return irregularVerbsDataStore.isDatabaseEmpty()
    }
}