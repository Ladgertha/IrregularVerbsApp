package ru.ladgertha.database_api

import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.entity.IrregularVerbItem

interface IrregularVerbsRepository {

    // fun saveVerbs()
    fun insert(irregularVerbItem: List<IrregularVerbItem>): Boolean

    fun isDatabaseEmpty(): Boolean

    fun getNextVerb(rareVerb: Boolean): IrregularVerb?
}