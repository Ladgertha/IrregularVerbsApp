package ru.ladgertha.datastore_api.usecase

interface SaveShowRareVerbsSettingsUseCase {

    suspend operator fun invoke(showRareVerbs: Boolean)
}