package com.kidnapsteal.bmodule


import android.app.Activity
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.kidnapsteal.TestApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import javax.inject.Provider

class BActivityTestRule(private val injector: (T: Activity) -> Unit) :
        ActivityTestRule<BActivity>(BActivity::class.java, true, false) {

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()

        val app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
        app.dispatchingAndroidInjector = createFakeActivityInjector(injector)

    }

    fun createFakeActivityInjector(activity: BActivity.() -> Unit)
            : DispatchingAndroidInjector<Activity> {
        val injector = AndroidInjector<Activity> { instance ->
            if (instance is BActivity) {
                instance.activity()
            }
        }
        val factory = AndroidInjector.Factory<Activity> { injector }
        val map = mapOf(Pair<Class<out Activity>,
                Provider<AndroidInjector.Factory<out Activity>>>(BActivity::class.java, Provider { factory }))

        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
    }
}