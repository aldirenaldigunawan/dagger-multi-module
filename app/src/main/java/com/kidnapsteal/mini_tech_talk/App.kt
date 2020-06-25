package com.kidnapsteal.mini_tech_talk

import android.app.Activity
import android.app.Application
import com.kidnapsteal.base.di.BaseComponent
import com.kidnapsteal.bmodule.di.BComponent
import com.kidnapsteal.commit.di.CommitComponent
import com.kidnapsteal.mini_tech_talk.di.AppComponent
import dagger.Dagger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

open class App : Application(), HasAndroidInjector {

    private lateinit var bComponent: BComponent
    private lateinit var baseComponent: BaseComponent
    private lateinit var commitComponent: CommitComponent
    private lateinit var appComponent: AppComponent

    override fun androidInjector(): AndroidInjector<Any> {
        return appComponent.androidInjector()
    }

    override fun onCreate() {
        super.onCreate()
        buildBaseComponent()
        buildBComponent()
        buildCommitComponent()
        buildAppComponent()
    }

//    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
//        buildBaseComponent()
//        buildBComponent()
//        buildCommitComponent()
//        buildAppComponent()
//        return appComponent
//    }

    private fun buildAppComponent(){
        appComponent = Dagger.builder(AppComponent.Builder::class.java)
                .baseComponent(baseComponent)
                .bComponent(bComponent)
                .cComponent(commitComponent)
                .application(this).build()
    }

    private fun buildBComponent() {
        bComponent = Dagger.builder(BComponent.builder::class.java).build()
    }

    private fun buildCommitComponent() {
        commitComponent = Dagger.builder(CommitComponent.Builder::class.java)
                .baseComponent(baseComponent)
                .build()

    }

    private fun buildBaseComponent() {
        baseComponent = Dagger.create(BaseComponent::class.java)
    }

}