package ru.ladgertha.datastore_api.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface GetShowRareVerbsSettingsUseCase {

    fun showRareVerbsSettings(): Flow<Boolean>
}