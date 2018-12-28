package com.kidnapsteal.commit.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


@Module
class NetworkModule {
  companion object {
    const val NAMED_BASE_URL = "named_base_url"
    const val BASE_URL = "https://api.github.com/"
    private const val ACCESS_TOKEN = "031f1b316c97e12e729ca69f22a058d7f479137c"
  }

  @Provides
  @Named(NAMED_BASE_URL)
  fun provideBaseUrl() = BASE_URL

  @Provides
  fun provideGson() = Gson()

  @Provides
  fun provideHttpInterceptor() = HttpLoggingInterceptor().setLevel(BODY)

  @Provides
  @Named("CUSTOM_INTERCEPTOR")
  fun provideCustomInterceptor() = Interceptor { chain ->
    var request = chain.request()
    val url = request.url().newBuilder().addQueryParameter(
        "access_token", ACCESS_TOKEN).build()
    request = request.newBuilder().url(url).build()
    chain.proceed(request)
  }

  @Provides
  fun providesOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor,
      @Named("CUSTOM_INTERCEPTOR") customInterceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(customInterceptor)
        .build()
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