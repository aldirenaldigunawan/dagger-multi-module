package com.kidnapsteal.mini_tech_talk.presentation.a

import dagger.Binds
import dagger.Module

@Module
abstract class AAbsModule {
    @Binds
    abstract fun bindAPresenter(presenter: APresenter): AContract.Presenter
}