package com.kidnapsteal.commit.di

import com.kidnapsteal.base.di.BaseComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import retrofit2.Retrofit

@Component(modules = [
    NetworkModule::class,
    CommitActivityBinding::class,
    AndroidSupportInjectionModule::class],
        dependencies = [BaseComponent::class])
interface CommitComponent{
    fun retrofit(): Retrofit
}