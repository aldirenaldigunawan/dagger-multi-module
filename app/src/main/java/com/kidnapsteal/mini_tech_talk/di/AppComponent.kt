package com.kidnapsteal.mini_tech_talk.di

import com.kidnapsteal.base.di.BaseComponent
import com.kidnapsteal.bmodule.di.BComponent
import com.kidnapsteal.commit.di.CommitActivityBinding
import com.kidnapsteal.commit.di.CommitComponent
import com.kidnapsteal.mini_tech_talk.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityBindingModule::class,
    CommitActivityBinding::class,
    AndroidSupportInjectionModule::class],
        dependencies = [BaseComponent::class, BComponent::class, CommitComponent::class])
interface AppComponent {

    fun <T> androidInjector(): DispatchingAndroidInjector<T>

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun baseComponent(baseComponent: BaseComponent): Builder

        fun bComponent(bComponent: BComponent): Builder

        fun cComponent(commitComponent: CommitComponent): Builder

        fun build(): AppComponent
    }

}