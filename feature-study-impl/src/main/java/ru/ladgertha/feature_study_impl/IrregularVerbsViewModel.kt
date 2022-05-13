package ru.ladgertha.feature_study_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import ru.ladgertha.database_api.entity.IrregularVerb
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
    private val getShowRareVerbsSettingsUseCase: GetShowRareVerbsSettingsUseCase
) : ViewModel() {
    // TODO Add progress bar
    private val currentWordFlow = MutableStateFlow<IrregularVerb?>(null)
    private val showRareVerbsFlow = getShowRareVerbsSettingsUseCase.showRareVerbsSettings()

    init {
        viewModelScope.launch {
            if (isDatabaseEmptyUseCase()) {
                insertIrregularVerbsUseCase.insert()
            }
        }
    }

    fun nextWord(rareVerb: Boolean) {
        viewModelScope.launch {
            currentWordFlow.value = getNextVerbUseCase.getNextVerb(rareVerb)
        }
    }

    fun updateShowRareVerbs(showRareVerbs: Boolean) {
        viewModelScope.launch {
            saveShowRareVerbsSettingsUseCase(showRareVerbs)
        }
    }

    internal fun getRareVerbsSettingsObservable() = showRareVerbsFlow
    internal fun getNextVerbObservable(): StateFlow<IrregularVerb?> = currentWordFlow
}