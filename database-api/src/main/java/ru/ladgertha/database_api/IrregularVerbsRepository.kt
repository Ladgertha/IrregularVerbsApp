package ru.ladgertha.database_api

import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.entity.IrregularVerbItem

interface IrregularVerbsRepository {

    // fun saveVerbs()
    fun insert(irregularVerbItems: List<IrregularVerbItem>): Boolean

    fun isDatabaseEmpty(): Boolean

    fun getNextVerb(rareVerb: Boolean): IrregularVerb?

    fun updateLastCheckedDate(verb: IrregularVerb)
}