package ru.ladgertha.database_impl.datastore

import ru.ladgertha.database_api.IrregularVerb
import ru.ladgertha.database_api.IrregularVerbsDataStore
import ru.ladgertha.database_impl.contract.IrregularVerbContract
import ru.ladgertha.database_impl.dao.IrregularVerbDao
import ru.ladgertha.database_impl.entity.IrregularVerbEntity

class IrregularVerbsDataStoreImpl(
    private val storageDao: IrregularVerbContract.DAO
) : IrregularVerbsDataStore {

    override fun insert(irregularVerb: List<IrregularVerb>): Boolean {
        val irregularVerbEntities = irregularVerb.map {
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
}