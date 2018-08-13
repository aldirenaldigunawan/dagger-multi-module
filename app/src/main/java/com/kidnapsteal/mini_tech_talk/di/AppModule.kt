package com.kidnapsteal.mini_tech_talk.di

import android.app.Application
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindsContext(context: Application): Application

}