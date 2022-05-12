package ru.ladgertha.feature_study_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.ladgertha.database_api.usecase.GetNextVerbUseCase
import ru.ladgertha.database_api.usecase.InsertIrregularVerbsUseCase
import ru.ladgertha.database_api.usecase.IsDatabaseEmptyUseCase
import ru.ladgertha.datastore_api.usecase.SaveShowRareVerbsSettingsUseCase

class IrregularVerbsViewModel(
    private val isDatabaseEmptyUseCase: IsDatabaseEmptyUseCase,
    private val insertIrregularVerbsUseCase: InsertIrregularVerbsUseCase,
    private val getNextVerbUseCase: GetNextVerbUseCase,
    private val saveShowRareVerbsSettingsUseCase: SaveShowRareVerbsSettingsUseCase
) : ViewModel() {
    // TODO Add progress bar
    private val currentWord = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch {
            if (isDatabaseEmptyUseCase()) {
                insertIrregularVerbsUseCase.insert()
            }
        }
    }

    fun nextWord() {
        viewModelScope.launch {

        }
    }

    fun updateShowRareVerbs(showRareVerbs: Boolean) {
        viewModelScope.launch {
            saveShowRareVerbsSettingsUseCase(showRareVerbs)
        }
    }
}