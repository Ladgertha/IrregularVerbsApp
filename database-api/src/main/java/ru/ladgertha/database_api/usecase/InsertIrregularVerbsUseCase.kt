package ru.ladgertha.database_api.usecase

interface InsertIrregularVerbsUseCase {

    suspend fun insert(): Boolean
}