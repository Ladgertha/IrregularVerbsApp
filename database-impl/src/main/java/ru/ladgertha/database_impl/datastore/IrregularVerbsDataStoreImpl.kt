package ru.ladgertha.database_impl.datastore

import ru.ladgertha.database_api.IrregularVerbsDataStore
import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.entity.IrregularVerbItem
import ru.ladgertha.database_impl.contract.IrregularVerbContract
import ru.ladgertha.database_impl.entity.IrregularVerbEntity

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
        val nextIrregularVerb = storageDao.getIrregularVerb(rareWord) ?: return null
        return IrregularVerb(
            baseForm = nextIrregularVerb.baseForm,
            pastParticiple = nextIrregularVerb.pastParticiple,
            pastSimple = nextIrregularVerb.pastSimple
        )
    }
}