package ru.ladgertha.datastore_api.repository

import kotlinx.coroutines.flow.Flow

interface IrregularVerbRepository {

    suspend fun saveShowRareVerbsSettings(showRareVerbs: Boolean)

    fun showRareVerbsSettings(): Flow<Boolean>
}