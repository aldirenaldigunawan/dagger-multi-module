package com.kidnapsteal.base


import android.app.Activity
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import dagger.android.DispatchingAndroidInjector

class InjectedActivityTestRule<T : Activity>(
        private val activityClass: Class<T>,
        private val dispatchingActivity: DispatchingAndroidInjector<Activity>) :
        ActivityTestRule<T>(activityClass, true, true) {

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()

        val app = InstrumentationRegistry.getTargetContext().applicationContext as BaseTestApplication
        app.dispatchingAndroidInjector = dispatchingActivity
    }
}