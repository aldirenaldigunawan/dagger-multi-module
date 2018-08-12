package com.kidnapsteal.base

import android.app.Activity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

abstract class BaseTestApplication : DaggerApplication(){
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
}