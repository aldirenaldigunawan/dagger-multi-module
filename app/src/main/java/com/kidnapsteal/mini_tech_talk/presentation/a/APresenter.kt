package com.kidnapsteal.mini_tech_talk.presentation.a

import com.kidnapsteal.base.RxScheduler
import com.kidnapsteal.base.composeIoUi
import io.reactivex.disposables.CompositeDisposable

class APresenter(private val api: API,
                 private val rxScheduler: RxScheduler) : AContract.Presenter {

    private lateinit var view: AContract.View
    private val disposeOnDetach = CompositeDisposable()

    override fun loadSomeething() {
        api.getRepos("rails")
                .toObservable()
                .flatMapIterable { it }
                .map { it.name }
                .toList()
                .composeIoUi(rxScheduler, view)
                .subscribe({
                    view.renderSomething(it)
                }, {}).let {
                    disposeOnDetach.add(it)
                }
    }

    override fun attachView(view: AContract.View) {
        this.view = view
    }

    override fun detachView() {
        disposeOnDetach.dispose()
    }

}