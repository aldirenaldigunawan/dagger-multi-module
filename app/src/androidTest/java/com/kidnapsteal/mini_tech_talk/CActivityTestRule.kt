package com.kidnapsteal.mini_tech_talk

import android.app.Activity
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.kidnapsteal.mini_tech_talk.presentation.a.AActivity
import com.kidnapsteal.mini_tech_talk.presentation.c.CActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import javax.inject.Provider

class CActivityTestRule(private val injector: (T : Activity) -> Unit) :
        ActivityTestRule<CActivity>(CActivity::class.java, true, false) {

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()

        val app = InstrumentationRegistry.getTargetContext().applicationContext as App
        app.dispatchingAndroidInjector = createFakeActivityInjector(injector)
    }

    fun createFakeActivityInjector(block : CActivity.() -> Unit)
            : DispatchingAndroidInjector<Activity> {
        val injector = AndroidInjector<Activity> { instance ->
            if (instance is CActivity) {
                instance.block()
            }
        }
        val factory = AndroidInjector.Factory<Activity> { injector }
        val map = mapOf(Pair<Class <out Activity>,
                Provider<AndroidInjector.Factory<out Activity>>>(CActivity::class.java, Provider { factory }))

        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
    }
}