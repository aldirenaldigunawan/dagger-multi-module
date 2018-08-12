package com.kidnapsteal.mini_tech_talk.di

import android.app.Application
import com.kidnapsteal.mini_tech_talk.utils.RxSchedulers
import com.kidnapsteal.mini_tech_talk.utils.RxSchedulersImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindsContext(context: Application): Application

    @Binds
    abstract fun rxScheduler(rxSchedulersImpl: RxSchedulersImpl): RxSchedulers
}