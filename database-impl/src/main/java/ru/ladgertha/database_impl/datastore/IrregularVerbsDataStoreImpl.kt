package ru.ladgertha.database_impl.datastore

import ru.ladgertha.database_api.IrregularVerbsDataStore
import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.entity.IrregularVerbItem
import ru.ladgertha.database_impl.contract.IrregularVerbContract
import ru.ladgertha.database_impl.entity.IrregularVerbEntity
import java.util.*

class IrregularVerbsDataStoreImpl(
    private val storageDao: IrregularVerbContract.DAO
) : IrregularVerbsDataStore {

    override fun insert(irregularVerbItem: List<IrregularVerbItem>): Boolean {
        val irregularVerbEntities = irregularVerbItem.map {
            IrregularVerbEntity(
                baseForm = it.baseForm,
                pastSimple = it.pastSimple,
                pastParticiple = it.pastParticiple,
                isPopular = it.isPopular,
                isDone = it.isDone,
                doneDate = it.doneDate,
                lastCheckedDate = it.lastCheckedDate
            )
        }
        //  lock.writeWithLock {
        storageDao.insert(irregularVerbEntities)
        return true
        // }
    }

    override fun isDatabaseEmpty(): Boolean {
        return storageDao.getFirstIrregularVerb() == null
    }

    override fun getNextVerb(rareWord: Boolean): IrregularVerb? {
        val nextIrregularVerb =
            storageDao.getIrregularVerb(rareWord, maximumCheckedTime)
                ?: storageDao.getIrregularVerb(rareWord)
                ?: return null
        return IrregularVerb(
            baseForm = nextIrregularVerb.baseForm,
            pastParticiple = nextIrregularVerb.pastParticiple,
            pastSimple = nextIrregularVerb.pastSimple
        )
    }

    override fun getIrregularVerbs(rareWord: Boolean): List<IrregularVerb>? {
        var irregularVerbs =
            storageDao.getIrregularVerbs(rareWord, maximumCheckedTime)
        if (irregularVerbs.isNullOrEmpty()) {
            irregularVerbs = storageDao.getIrregularVerbs(rareWord)
        }
        if (irregularVerbs.isNullOrEmpty()) return null
        return irregularVerbs.map {
            IrregularVerb(
                baseForm = it.baseForm,
                pastParticiple = it.pastParticiple,
                pastSimple = it.pastSimple
            )
        }
    }

    override fun updateLastCheckedDate(verb: IrregularVerb) {
        storageDao.updateLastCheckedDateByBaseForm(verb.baseForm, Date().time)
    }

    companion object {
        private const val TWENTY_FOUR_HOURS = 86400000L
        private val maximumCheckedTime = Date().time - TWENTY_FOUR_HOURS
    }
}