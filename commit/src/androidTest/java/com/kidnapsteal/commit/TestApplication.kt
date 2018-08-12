package com.kidnapsteal.commit

import android.app.Activity
import com.kidnapsteal.base.BaseTestApplication
import com.kidnapsteal.base.Mocker
import com.kidnapsteal.commit.di.DaggerCommitComponent
import com.nhaarman.mockitokotlin2.mock
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication

class TestApplication : BaseTestApplication() {

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerCommitComponent
                .builder()
                .baseComponent(Mocker.create())
                .build()
    }
}