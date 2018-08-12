package com.kidnapsteal.bmodule.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@Component(modules = [
    BActivityModule::class,
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class])
interface BComponent : AndroidInjector<DaggerApplication>