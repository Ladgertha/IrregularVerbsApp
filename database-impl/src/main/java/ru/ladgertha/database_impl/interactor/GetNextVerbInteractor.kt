package ru.ladgertha.database_impl.interactor

import ru.ladgertha.database_api.usecase.GetNextVerbUseCase

class GetNextVerbInteractor : GetNextVerbUseCase {

    override suspend fun getNextVerb(): String {
//        return withContext() {
//            // TODO Вынести диспатчеры в отдельный модуль
//        }
        return ""
    }
}