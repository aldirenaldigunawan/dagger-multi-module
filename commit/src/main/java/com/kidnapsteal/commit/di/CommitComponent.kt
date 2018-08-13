package com.kidnapsteal.commit.di

import com.kidnapsteal.base.di.BaseComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    CommitModule::class,
    CommitActivityBinding::class,
    AndroidSupportInjectionModule::class],
        dependencies = [BaseComponent::class])
interface CommitComponent