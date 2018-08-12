package com.kidnapsteal.commit.di

import android.app.Activity
import com.kidnapsteal.commit.API
import com.kidnapsteal.commit.CommitActivity
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class CommitModule {

    companion object {
        const val NAMED_USER_NAME = "named_user_name"
        const val NAMED_USER_REPO = "named_user_repo"
    }

    @Provides
    fun provideCommitAPI(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }

    @Provides
    @Named(NAMED_USER_NAME)
    fun provideUserName(activity: CommitActivity): String {
        return activity.intent.getStringExtra(CommitActivity.EXTRA_USER_NAME)
    }

    @Provides
    @Named(NAMED_USER_REPO)
    fun provideUserRepo(activity: CommitActivity): String {
        return activity.intent.getStringExtra(CommitActivity.EXTRA_USER_REPO)
    }

}