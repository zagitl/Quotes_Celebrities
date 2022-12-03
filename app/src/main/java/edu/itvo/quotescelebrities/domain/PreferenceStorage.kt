package edu.itvo.quotescelebrities.domain

import kotlinx.coroutines.flow.Flow


interface PreferenceStorage {
    fun getToken() : Flow<String>
    suspend fun saveToken(token: String)

}