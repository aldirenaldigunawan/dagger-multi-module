package com.kidnapsteal.bmodule.di

import com.kidnapsteal.bmodule.BActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BActivityModule {

    @ContributesAndroidInjector(modules = [BModule::class])
    abstract fun bActivity(): BActivity

}