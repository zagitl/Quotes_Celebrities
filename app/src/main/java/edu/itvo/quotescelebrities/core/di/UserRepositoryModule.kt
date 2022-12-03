package edu.itvo.quotescelebrities.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.itvo.quotescelebrities.data.UserRepositoryImpl
import edu.itvo.quotescelebrities.data.remote.UserRemoteDataSource
import edu.itvo.quotescelebrities.data.remote.UserRemoteDataSourceImpl
import edu.itvo.quotescelebrities.domain.UserRepository


@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl):
            UserRepository

    @Binds
    abstract fun bindUserRemoteDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl):
            UserRemoteDataSource


}
