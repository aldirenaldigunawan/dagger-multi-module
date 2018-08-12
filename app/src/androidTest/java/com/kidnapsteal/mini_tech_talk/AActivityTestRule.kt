package com.kidnapsteal.mini_tech_talk

import android.app.Activity
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.kidnapsteal.mini_tech_talk.presentation.a.AActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import javax.inject.Provider

class AActivityTestRule(private val injector: (T : Activity) -> Unit) :
        ActivityTestRule<AActivity>(AActivity::class.java, true, false) {

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()

        val app = InstrumentationRegistry.getTargetContext().applicationContext as App
        app.dispatchingAndroidInjector = createFakeActivityInjector(injector)
    }

    fun createFakeActivityInjector(block : AActivity.() -> Unit)
            : DispatchingAndroidInjector<Activity> {
        val injector = AndroidInjector<Activity> { instance ->
            if (instance is AActivity) {
                instance.block()
            }
        }
        val factory = AndroidInjector.Factory<Activity> { injector }
        val map = mapOf(Pair<Class <out Activity>,
                Provider<AndroidInjector.Factory<out Activity>>>(AActivity::class.java, Provider { factory }))

        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
    }
}