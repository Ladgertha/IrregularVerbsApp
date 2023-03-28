package ru.ladgertha.database_impl.repository

import ru.ladgertha.database_api.IrregularVerbsDataStore
import ru.ladgertha.database_api.IrregularVerbsRepository
import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.entity.IrregularVerbItem
import ru.ladgertha.database_impl.datastore.IrregularVerbsCacheDatastore

class IrregularVerbsRepositoryImpl(
    private val irregularVerbsCacheDatastore: IrregularVerbsCacheDatastore,
    private val irregularVerbsDataStore: IrregularVerbsDataStore
) : IrregularVerbsRepository {

    override fun insert(irregularVerbItems: List<IrregularVerbItem>): Boolean {
        return irregularVerbsDataStore.insert(irregularVerbItems)
    }

    override fun isDatabaseEmpty(): Boolean {
        return irregularVerbsDataStore.isDatabaseEmpty()
    }

    override fun getNextVerb(rareVerb: Boolean): IrregularVerb? {
        val nextVerb = irregularVerbsCacheDatastore.getNextVerb()
        if (nextVerb == null) {
            val irregularVerbs = irregularVerbsDataStore.getIrregularVerbs(rareVerb)
            return if (irregularVerbs != null) {
                irregularVerbsCacheDatastore.saveVerbsInCache(irregularVerbs)
                irregularVerbsCacheDatastore.getNextVerb()
            } else {
                null
            }

        }
        return nextVerb
    }

    override fun updateLastCheckedDate(verb: IrregularVerb) {
        irregularVerbsDataStore.updateLastCheckedDate(verb)
    }
}