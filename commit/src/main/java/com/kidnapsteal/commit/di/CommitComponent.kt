package com.kidnapsteal.commit.di

import com.kidnapsteal.base.di.BaseComponent
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@Component(modules = [
    CommitActivityBinding::class,
    AndroidSupportInjectionModule::class],
        dependencies = [BaseComponent::class])
interface CommitComponent : AndroidInjector<DaggerApplication>