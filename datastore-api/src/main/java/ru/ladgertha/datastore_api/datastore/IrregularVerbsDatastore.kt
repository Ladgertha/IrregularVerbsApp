package ru.ladgertha.datastore_api.datastore

import kotlinx.coroutines.flow.Flow

interface IrregularVerbsDatastore {

    suspend fun saveShowRareVerbsSettings(showRareVerbs: Boolean)

    fun showRareVerbsSettings(): Flow<Boolean>
}