package com.kidnapsteal.mini_tech_talk

import android.app.Activity
import com.kidnapsteal.base.di.BaseComponent
import com.kidnapsteal.base.di.DaggerBaseComponent
import com.kidnapsteal.bmodule.di.BComponent
import com.kidnapsteal.bmodule.di.DaggerBComponent
import com.kidnapsteal.commit.di.CommitComponent
import com.kidnapsteal.commit.di.DaggerCommitComponent
import com.kidnapsteal.mini_tech_talk.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

open class App : DaggerApplication(), HasActivityInjector {

    private lateinit var bComponent: BComponent
    private lateinit var baseComponent: BaseComponent
    private lateinit var commitComponent: CommitComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        buildBaseComponent()
        buildBComponent()
        buildCommitComponent()
        return DaggerAppComponent.builder()
                .baseComponent(baseComponent)
                .bComponent(bComponent)
                .cComponent(commitComponent)
                .application(this).build()
    }

    private fun buildBComponent() {
        bComponent = DaggerBComponent.builder().build()
    }

    private fun buildCommitComponent() {
        commitComponent = DaggerCommitComponent.builder().baseComponent(baseComponent).build()
    }

    private fun buildBaseComponent() {
        baseComponent = DaggerBaseComponent.create()
    }

}