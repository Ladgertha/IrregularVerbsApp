package ru.ladgertha.database_api

interface IrregularVerbsDataStore {

    fun insert(irregularVerb: List<IrregularVerb>): Boolean

    fun isDatabaseEmpty(): Boolean
}