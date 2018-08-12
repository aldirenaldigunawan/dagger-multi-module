package com.kidnapsteal.commit.di

import com.kidnapsteal.commit.CommitContract
import com.kidnapsteal.commit.CommitPresenter
import com.kidnapsteal.commit.data.CommitRepository
import com.kidnapsteal.commit.data.CommitRepositoryImpl
import com.kidnapsteal.commit.domain.GetCommitUseCase
import com.kidnapsteal.commit.domain.GetCommitUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CommitAbsModule {

    @Binds
    abstract fun bindRepository(commitRepositoryImpl: CommitRepositoryImpl): CommitRepository

    @Binds
    abstract fun bindCommitUseCase(commitUseCaseImpl: GetCommitUseCaseImpl): GetCommitUseCase

    @Binds
    abstract fun bindPresenter(commitPresenter: CommitPresenter): CommitContract.Presenter
}