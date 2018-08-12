package com.kidnapsteal.mini_tech_talk.presentation.a

import com.kidnapsteal.mini_tech_talk.presentation.a.AActivity.Companion.EXTRA_ID
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class AModule {

    @Provides
    @Named("NAME_EXTRA_ID")
    fun provideExtraId(activity: AActivity): String {
        return activity.intent.getStringExtra(EXTRA_ID)
    }

}