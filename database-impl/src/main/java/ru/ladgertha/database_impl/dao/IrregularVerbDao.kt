package ru.ladgertha.database_impl.dao

import androidx.room.Dao
import androidx.room.Query
import ru.ladgertha.database_impl.contract.IrregularVerbContract
import ru.ladgertha.database_impl.entity.IrregularVerbEntity

@Dao
abstract class IrregularVerbDao : IrregularVerbContract.DAO {

    @Query("SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS}")
    abstract override fun getIrregularVerbs(): List<IrregularVerbEntity>?
}