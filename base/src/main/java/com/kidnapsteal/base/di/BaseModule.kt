package com.kidnapsteal.base.di

import com.kidnapsteal.base.RxScheduler
import com.kidnapsteal.base.RxSchedulerImpl
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
class BaseModule {

    @Provides
    fun provideRxSchedulers(): RxScheduler {
        return RxSchedulerImpl(
                Schedulers.io(),
                AndroidSchedulers.mainThread(),
                Schedulers.computation(),
                Schedulers.newThread()
        )
    }

}