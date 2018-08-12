package com.kidnapsteal.mini_tech_talk

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class TestApp : App(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return super.applicationInjector()
    }
}