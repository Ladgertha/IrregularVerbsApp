package ru.ladgertha.datastore_impl.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.datastore_api.repository.IrregularVerbRepository
import ru.ladgertha.datastore_api.usecase.SaveShowRareVerbsSettingsUseCase

class SaveShowRareVerbsSettingsInteractor(
    private val repository: IrregularVerbRepository
) : SaveShowRareVerbsSettingsUseCase {

    override suspend fun invoke(showRareVerbs: Boolean) {
        withContext(Dispatchers.IO) {
            repository.saveShowRareVerbsSettings(showRareVerbs)
        }
    }
}