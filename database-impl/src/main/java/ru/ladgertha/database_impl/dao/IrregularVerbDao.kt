package ru.ladgertha.database_impl.dao

import androidx.room.Dao
import androidx.room.Query
import ru.ladgertha.database_impl.contract.IrregularVerbContract
import ru.ladgertha.database_impl.entity.IrregularVerbEntity

@Dao
abstract class IrregularVerbDao : IrregularVerbContract.DAO {

    @Query("SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS}")
    abstract override fun getIrregularVerbs(): List<IrregularVerbEntity>?

    @Query("SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS} LIMIT 1")
    abstract override fun getFirstIrregularVerb(): IrregularVerbEntity?

    @Query("SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS} " +
            "WHERE ${IrregularVerbContract.DAO.KEY_IS_POPULAR} = :rareVerb LIMIT 1")
    abstract override fun getIrregularVerb(rareVerb: Boolean): IrregularVerbEntity?
}