package ru.ladgertha.database_api

interface IrregularVerbsRepository {

   // fun saveVerbs()
   fun insert(irregularVerb: List<IrregularVerb>): Boolean

   fun isDatabaseEmpty(): Boolean
}