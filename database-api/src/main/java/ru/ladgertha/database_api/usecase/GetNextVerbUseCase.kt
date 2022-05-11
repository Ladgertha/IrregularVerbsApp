package ru.ladgertha.database_api.usecase

interface GetNextVerbUseCase {

    suspend fun getNextVerb(): String
}