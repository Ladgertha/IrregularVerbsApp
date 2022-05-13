package ru.ladgertha.datastore_impl.interactor

import kotlinx.coroutines.flow.Flow
import ru.ladgertha.datastore_api.repository.IrregularVerbRepository
import ru.ladgertha.datastore_api.usecase.GetShowRareVerbsSettingsUseCase

class GetShowRareVerbsSettingsInteractor(
    private val repository: IrregularVerbRepository
) : GetShowRareVerbsSettingsUseCase {

    override fun showRareVerbsSettings(): Flow<Boolean> {
        return repository.showRareVerbsSettings()
    }
}