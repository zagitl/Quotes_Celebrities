package edu.itvo.quotescelebrities.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.itvo.quotescelebrities.data.PreferenceStorageImpl
import edu.itvo.quotescelebrities.domain.PreferenceStorage

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {
    @Binds
    abstract fun bindPreferenceStorage(preferenceStorageImpl: PreferenceStorageImpl):
            PreferenceStorage
}
