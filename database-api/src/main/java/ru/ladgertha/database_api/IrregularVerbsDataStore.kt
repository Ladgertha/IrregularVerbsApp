package ru.ladgertha.database_api

import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.entity.IrregularVerbItem

interface IrregularVerbsDataStore {

    fun insert(irregularVerbItem: List<IrregularVerbItem>): Boolean

    fun isDatabaseEmpty(): Boolean

    fun getNextVerb(rareWord: Boolean): IrregularVerb?

    fun updateLastCheckedDate(verb: IrregularVerb)
}