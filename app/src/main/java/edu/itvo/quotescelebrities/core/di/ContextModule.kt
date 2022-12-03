package edu.itvo.quotescelebrities.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.itvo.quotescelebrities.QuotesApp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: QuotesApp): Context {
        return application.applicationContext
    }

}