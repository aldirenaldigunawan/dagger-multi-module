package com.kidnapsteal.bmodule.di

import com.kidnapsteal.bmodule.BActivity
import com.kidnapsteal.bmodule.BContract
import com.kidnapsteal.bmodule.BPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BModule {

    companion object {
        const val NAMED_USER_ID = "named_string_a"
    }

    @Provides
    @Named(NAMED_USER_ID)
    fun provideStringA(activity: BActivity): String {
        return activity.intent.getStringExtra(BActivity.EXTRA_USER_ID)
    }

    @Provides
    fun providePresenter(@Named(NAMED_USER_ID) userId: String): BContract.Presenter {
        return BPresenter(userId)
    }
}