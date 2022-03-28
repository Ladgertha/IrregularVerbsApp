package ru.ladgertha.feature_study_impl.interactor

import kotlinx.coroutines.withContext
import ru.ladgertha.feature_study_api.GetNextWordUseCase

class GetNextWordInteractor: GetNextWordUseCase {

    override suspend fun getNextWord(): String {
//        return withContext() {
//            // TODO Вынести диспатчеры в отдельный модуль
//        }
        return ""
    }
}