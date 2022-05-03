package ru.ladgertha.database_impl.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ladgertha.database_api.IrregularVerbsRepository
import ru.ladgertha.database_api.usecase.InsertIrregularVerbsUseCase
import ru.ladgertha.database_impl.converter.IrregularVerbsFromJsonConverter

class InsertIrregularVerbsInteractor(
    private val irregularVerbsRepository: IrregularVerbsRepository,
    private val irregularVerbsFromJsonConverter: IrregularVerbsFromJsonConverter
) : InsertIrregularVerbsUseCase {

    override suspend fun insert(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val irregularVerbs = irregularVerbsFromJsonConverter.getIrregularVerbs()
                irregularVerbsRepository.insert(irregularVerbs)
                true
            } catch (exception: Exception) {
                // TODO Add logs
                false
            }
        }
    }
}