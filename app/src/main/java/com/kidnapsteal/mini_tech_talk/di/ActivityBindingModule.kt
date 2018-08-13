package com.kidnapsteal.mini_tech_talk.di

import com.kidnapsteal.mini_tech_talk.MainActivity
import com.kidnapsteal.mini_tech_talk.presentation.a.AActivity
import com.kidnapsteal.mini_tech_talk.presentation.a.AModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [AModule::class])
    internal abstract fun aActivity(): AActivity
}