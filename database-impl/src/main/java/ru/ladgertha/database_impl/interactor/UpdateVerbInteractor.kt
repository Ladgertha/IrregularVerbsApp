package ru.ladgertha.database_impl.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.database_api.IrregularVerbsRepository
import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.usecase.UpdateVerbUseCase

class UpdateVerbInteractor(
    private val irregularVerbsRepository: IrregularVerbsRepository
) : UpdateVerbUseCase {

    override suspend fun updateLastCheckedDate(verb: IrregularVerb) {
        withContext(Dispatchers.IO) {
            irregularVerbsRepository.updateLastCheckedDate(verb)
        }
    }
}