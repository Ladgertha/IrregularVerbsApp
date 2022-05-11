package ru.ladgertha.datastore_api

import kotlinx.coroutines.flow.Flow

interface IrregularVerbsDatastore {

    suspend fun saveShowRareVerbsSettings(showRareVerbs: Boolean)

    fun showRareVerbsSettings(): Flow<Boolean>
}