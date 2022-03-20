package ru.ladgertha.database_impl.database

import ru.ladgertha.database_impl.contract.IrregularVerbContract

interface IStorageDatabase {

    fun irregularVerbDao(): IrregularVerbContract.DAO
}