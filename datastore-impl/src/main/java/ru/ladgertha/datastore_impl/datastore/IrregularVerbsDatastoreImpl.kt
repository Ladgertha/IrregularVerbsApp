package ru.ladgertha.datastore_impl.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.ladgertha.datastore_api.datastore.IrregularVerbsDatastore

class IrregularVerbsDatastoreImpl(
    private val context: Context
) : IrregularVerbsDatastore {

    private val Context.dataStore by preferencesDataStore(
        name = SETTINGS_DATASTORE
    )

    override suspend fun saveShowRareVerbsSettings(showRareVerbs: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[SHOW_RARE_VERBS_KEY] = showRareVerbs
        }
    }

    override fun showRareVerbsSettings(): Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[SHOW_RARE_VERBS_KEY] ?: false
        }

    companion object {
        private const val SETTINGS_DATASTORE = "settings_datastore"
        private const val SHOW_RARE_VERBS_TEXT = "show_rare_verbs"
        private val SHOW_RARE_VERBS_KEY = booleanPreferencesKey(SHOW_RARE_VERBS_TEXT)
    }
}