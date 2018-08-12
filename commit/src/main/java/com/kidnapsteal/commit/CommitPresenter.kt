package com.kidnapsteal.commit

import com.kidnapsteal.base.RxScheduler
import com.kidnapsteal.base.composeIoUi
import com.kidnapsteal.commit.di.CommitModule
import com.kidnapsteal.commit.domain.GetCommitUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class CommitPresenter @Inject constructor(
        @Named(CommitModule.NAMED_USER_NAME) private val userName: String,
        @Named(CommitModule.NAMED_USER_REPO) private val repos: String,
        private val useCase: GetCommitUseCase,
        private val rxScheduler: RxScheduler
) : CommitContract.Presenter {

    private lateinit var view: CommitContract.View
    private val disposeOnDestroy = CompositeDisposable()

    override fun attachView(view: CommitContract.View) {
        this.view = view
    }

    override fun detachView() {
        disposeOnDestroy.dispose()
    }

    override fun loadCommit(limit: Int) {
        useCase.execute(userName, repos, limit)
                .composeIoUi(rxScheduler, view)
                .subscribe({
                    view.renderCommits(it)
                }, {}).let {
                    disposeOnDestroy.add(it)
                }
    }

}