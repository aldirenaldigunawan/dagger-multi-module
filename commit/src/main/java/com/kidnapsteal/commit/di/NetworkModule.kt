package com.kidnapsteal.commit.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule{
    companion object {
        const val NAMED_BASE_URL = "named_base_url"
        const val BASE_URL = "https://api.github.com/"
    }

    @Provides
    @Named(NAMED_BASE_URL)
    fun provideBaseUrl() = BASE_URL

    @Provides
    fun provideGson() = Gson()

    @Provides
    fun provideHttpInterceptor() = HttpLoggingInterceptor()

    @Provides
    fun providesOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    fun provideGsonConverter(gson: Gson) = GsonConverterFactory.create(gson)

    @Provides
    fun provideRxJavaAdapter() = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideRetrofit(
            @Named(NAMED_BASE_URL) baseUrl: String,
            client: OkHttpClient,
            gsonConverter: GsonConverterFactory,
            rxJavaAdapter: RxJava2CallAdapterFactory): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(gsonConverter)
                .addCallAdapterFactory(rxJavaAdapter)
                .build()
    }
}