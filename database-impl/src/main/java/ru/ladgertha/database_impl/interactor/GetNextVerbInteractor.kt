package ru.ladgertha.database_impl.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.database_api.IrregularVerbsRepository
import ru.ladgertha.database_api.entity.IrregularVerb
import ru.ladgertha.database_api.usecase.GetNextVerbUseCase

class GetNextVerbInteractor(
    private val repository: IrregularVerbsRepository
) : GetNextVerbUseCase {

    override suspend fun getNextVerb(rareWord: Boolean): IrregularVerb? {
        return withContext(Dispatchers.IO) {
            repository.getNextVerb(rareWord)
        }
    }
}