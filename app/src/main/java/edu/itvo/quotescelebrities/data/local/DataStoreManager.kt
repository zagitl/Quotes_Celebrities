package edu.itvo.quotescelebrities.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreManager(val context: Context) {

    private val USERDATASTORE = "quotescelebrities"

    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = USERDATASTORE)

    companion object {
        val TOKEN = stringPreferencesKey("TOKEN")
    }

    suspend fun saveTokenToDataStore(token: String) {
        context.dataStore.edit {
            it[TOKEN] = token
        }
    }

    val token : Flow<String>
        get() = context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[TOKEN] ?: ""
            }

}
