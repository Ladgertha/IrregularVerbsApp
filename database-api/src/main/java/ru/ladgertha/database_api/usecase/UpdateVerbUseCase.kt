package ru.ladgertha.database_api.usecase

import ru.ladgertha.database_api.entity.IrregularVerb

interface UpdateVerbUseCase {

    suspend fun updateLastCheckedDate(verb: IrregularVerb)
}