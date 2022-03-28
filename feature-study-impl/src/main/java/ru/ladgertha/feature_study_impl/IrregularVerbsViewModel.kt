package ru.ladgertha.feature_study_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class IrregularVerbsViewModel: ViewModel() {

    fun nextWord() {
        viewModelScope.launch {

        }
    }
}