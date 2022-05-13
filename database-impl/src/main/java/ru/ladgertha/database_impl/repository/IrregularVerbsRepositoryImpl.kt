package ru.ladgertha.database_impl.repository

import ru.ladgertha.database_api.entity.IrregularVerbItem
import ru.ladgertha.database_api.IrregularVerbsDataStore
import ru.ladgertha.database_api.IrregularVerbsRepository
import ru.ladgertha.database_api.entity.IrregularVerb

class IrregularVerbsRepositoryImpl(
    private val irregularVerbsDataStore: IrregularVerbsDataStore
): IrregularVerbsRepository {

    override fun insert(irregularVerbItems: List<IrregularVerbItem>): Boolean {
        return irregularVerbsDataStore.insert(irregularVerbItems)
    }

    override fun isDatabaseEmpty(): Boolean {
        return irregularVerbsDataStore.isDatabaseEmpty()
    }

    override fun getNextVerb(rareVerb: Boolean): IrregularVerb? {
        return irregularVerbsDataStore.getNextVerb(rareVerb)
    }
}