package ru.ladgertha.database_impl.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.database_api.IrregularVerbsRepository
import ru.ladgertha.database_api.usecase.IsDatabaseEmptyUseCase

class IsDatabaseEmptyInteractor(
    private val irregularVerbsRepository: IrregularVerbsRepository
): IsDatabaseEmptyUseCase {

    override suspend fun invoke(): Boolean {
        return withContext(Dispatchers.IO) {
            irregularVerbsRepository.isDatabaseEmpty()
        }
    }
}