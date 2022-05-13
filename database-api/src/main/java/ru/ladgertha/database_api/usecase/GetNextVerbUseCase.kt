package ru.ladgertha.database_api.usecase

import ru.ladgertha.database_api.entity.IrregularVerb

interface GetNextVerbUseCase {

    suspend fun getNextVerb(rareWord: Boolean): IrregularVerb?
}