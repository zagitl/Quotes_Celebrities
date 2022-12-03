package edu.itvo.quotescelebrities.core.di

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.itvo.quotescelebrities.data.remote.QuoteApiInterface

import edu.itvo.quotescelebrities.data.remote.QuoteRemoteDataSourceImpl
import edu.itvo.quotescelebrities.data.remote.UserApiInterface
import edu.itvo.quotescelebrities.data.remote.UserRemoteDataSourceImpl
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "http://192.168.0.14:2022/"

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    private val READ_TIMEOUT = 30
    private val WRITE_TIMEOUT = 30
    private val CONNECTION_TIMEOUT = 10
    private val CACHE_SIZE_BYTES = 10 * 1024 * 1024L // 10 MB

    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor: Interceptor,
        cache: Cache
    ): OkHttpClient {

        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.cache(cache)
        okHttpClientBuilder.addInterceptor(headerInterceptor)


        return okHttpClientBuilder.build()
    }


    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor {
            val requestBuilder = it.request().newBuilder()
            //hear you can add all headers you want by calling 'requestBuilder.addHeader(name ,  value)'
            it.proceed(requestBuilder.build())
        }
    }


    @Provides
    @Singleton
    internal fun provideCache(context: Context): Cache {
        val httpCacheDirectory = File(context.cacheDir.absolutePath, "HttpCache")
        return Cache(httpCacheDirectory, CACHE_SIZE_BYTES)
    }

    @Singleton
    @Provides
    fun provideQuoteRemoteDataSourceImpl(quoteApiInterface: QuoteApiInterface) =
        QuoteRemoteDataSourceImpl(quoteApiInterface)

    @Singleton
    @Provides
    fun provideQuoteApiInterface(retrofit: Retrofit): QuoteApiInterface =
        retrofit.create(QuoteApiInterface::class.java)

    //--- injection for class and interfaces User
    @Singleton
    @Provides
    fun provideUserRemoteDataSourceImpl(userApiInterface: UserApiInterface) =
        UserRemoteDataSourceImpl(userApiInterface)

    @Singleton
    @Provides
    fun provideUserApiInterface(retrofit: Retrofit): UserApiInterface =
        retrofit.create(UserApiInterface::class.java)
}