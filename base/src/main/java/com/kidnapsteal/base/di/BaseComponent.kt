package com.kidnapsteal.base.di

import com.google.gson.Gson
import com.kidnapsteal.base.RxScheduler
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Component(modules = [BaseModule::class,
    AndroidSupportInjectionModule::class])
interface BaseComponent : AndroidInjector<DaggerApplication> {
    fun rxScheduler(): RxScheduler
}