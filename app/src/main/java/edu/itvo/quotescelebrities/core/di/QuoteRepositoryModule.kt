package edu.itvo.quotescelebrities.core.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.itvo.quotescelebrities.data.QuoteRepositoryImpl
import edu.itvo.quotescelebrities.data.local.QuoteLocalDataSource
import edu.itvo.quotescelebrities.data.local.QuoteLocalDataSourceImpl
import edu.itvo.quotescelebrities.data.local.daos.QuoteDao
import edu.itvo.quotescelebrities.data.remote.QuoteRemoteDataSource
import edu.itvo.quotescelebrities.data.remote.QuoteRemoteDataSourceImpl
import edu.itvo.quotescelebrities.domain.QuoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):
            QuoteRepository

    @Binds
    abstract fun bindQuoteLocalDataSource(quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl):
            QuoteLocalDataSource

    @Binds
    abstract fun bindQuoteRemoteDataSource(quoteRemoteDataSourceImpl: QuoteRemoteDataSourceImpl):
            QuoteRemoteDataSource




}
