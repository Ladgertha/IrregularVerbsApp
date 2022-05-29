package ru.ladgertha.feature_study_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.ladgertha.database_api.usecase.GetNextVerbUseCase
import ru.ladgertha.database_api.usecase.InsertIrregularVerbsUseCase
import ru.ladgertha.database_api.usecase.IsDatabaseEmptyUseCase
import ru.ladgertha.datastore_api.usecase.GetShowRareVerbsSettingsUseCase
import ru.ladgertha.datastore_api.usecase.SaveShowRareVerbsSettingsUseCase

class IrregularVerbsViewModel(
    private val isDatabaseEmptyUseCase: IsDatabaseEmptyUseCase,
    private val insertIrregularVerbsUseCase: InsertIrregularVerbsUseCase,
    private val getNextVerbUseCase: GetNextVerbUseCase,
    private val saveShowRareVerbsSettingsUseCase: SaveShowRareVerbsSettingsUseCase,
    getShowRareVerbsSettingsUseCase: GetShowRareVerbsSettingsUseCase
) : ViewModel() {
    private val showRareVerbsFlow = getShowRareVerbsSettingsUseCase.showRareVerbsSettings()
    private val screenStateFlow = MutableStateFlow<ScreenState>(ScreenState.Loading)
    private val databaseIsUpdatedFlow = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            screenStateFlow.value = ScreenState.Loading
            if (isDatabaseEmptyUseCase()) {
                insertIrregularVerbsUseCase.insert()
            }
            databaseIsUpdatedFlow.value = true
        }
    }

    fun nextWord(rareVerb: Boolean) {
        viewModelScope.launch {
            val nextVerb = getNextVerbUseCase.getNextVerb(rareVerb)
            nextVerb?.baseForm?.let {
                screenStateFlow.value = ScreenState.Content(it)
            }
        }
    }

    fun updateShowRareVerbs(showRareVerbs: Boolean) {
        viewModelScope.launch {
            saveShowRareVerbsSettingsUseCase(showRareVerbs)
        }
    }

    internal fun getRareVerbsSettingsObservable() = showRareVerbsFlow
    internal fun getScreenStateObservable(): StateFlow<ScreenState> = screenStateFlow
    internal fun getDatabaseIsUpdatedObservable(): StateFlow<Boolean> = databaseIsUpdatedFlow

    internal sealed class ScreenState {
        object Loading : ScreenState()
        data class Content(val baseForm: String) : ScreenState()
    }
}