package com.kidnapsteal.commit.di

import com.kidnapsteal.commit.presentation.CommitActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CommitActivityBinding {

    @ContributesAndroidInjector(modules = [CommitModule::class, CommitAbsModule::class, NetworkModule::class])
    abstract fun cActivity(): CommitActivity

}