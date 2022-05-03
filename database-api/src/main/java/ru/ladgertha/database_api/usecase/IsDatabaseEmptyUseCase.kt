package ru.ladgertha.database_api.usecase

interface IsDatabaseEmptyUseCase {

    suspend operator fun invoke(): Boolean
}