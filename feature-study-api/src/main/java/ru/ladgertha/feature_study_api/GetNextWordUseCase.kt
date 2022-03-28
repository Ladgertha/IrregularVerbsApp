package ru.ladgertha.feature_study_api

interface GetNextWordUseCase {

    suspend fun getNextWord(): String
}