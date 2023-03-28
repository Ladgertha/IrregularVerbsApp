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

    @Query(
        "SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS} " +
                "WHERE ${IrregularVerbContract.DAO.KEY_IS_POPULAR} = :rareVerb " +
                "AND ${IrregularVerbContract.DAO.KEY_LAST_CHECKED_DATE} <= :lastCheckedTime " +
                "LIMIT 1"
    )
    abstract override fun getIrregularVerb(
        rareVerb: Boolean,
        lastCheckedTime: Long
    ): IrregularVerbEntity?

    @Query(
        "SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS} " +
                "WHERE ${IrregularVerbContract.DAO.KEY_IS_POPULAR} = :rareVerb " +
                "AND ${IrregularVerbContract.DAO.KEY_LAST_CHECKED_DATE} <= :lastCheckedTime "
    )
    abstract override fun getIrregularVerbs(
        rareVerb: Boolean,
        lastCheckedTime: Long
    ): List<IrregularVerbEntity>?

    @Query(
        "SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS} " +
                "WHERE ${IrregularVerbContract.DAO.KEY_IS_POPULAR} = :rareVerb " +
                "AND ${IrregularVerbContract.DAO.KEY_LAST_CHECKED_DATE} IS NULL " +
                "LIMIT 1"
    )
    abstract override fun getIrregularVerb(
        rareVerb: Boolean
    ): IrregularVerbEntity?

    @Query(
        "SELECT * FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS} " +
                "WHERE ${IrregularVerbContract.DAO.KEY_IS_POPULAR} = :rareVerb " +
                "AND ${IrregularVerbContract.DAO.KEY_LAST_CHECKED_DATE} IS NULL "
    )
    abstract override fun getIrregularVerbs(
        rareVerb: Boolean
    ): List<IrregularVerbEntity>?

    @Query(
        "UPDATE ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS} " +
                "SET ${IrregularVerbContract.DAO.KEY_LAST_CHECKED_DATE} = :lastCheckedTime " +
                "WHERE ${IrregularVerbContract.DAO.KEY_BASE_FORM} = :baseForm"
    )
    abstract override fun updateLastCheckedDateByBaseForm(baseForm: String, lastCheckedTime: Long)

    @Query(
        "SELECT COUNT(${IrregularVerbContract.DAO.KEY_BASE_FORM}) FROM ${IrregularVerbContract.DAO.TABLE_NAME_IRREGULAR_VERBS}"
    )
    abstract override fun getIrregularVerbsCount(): Int
}