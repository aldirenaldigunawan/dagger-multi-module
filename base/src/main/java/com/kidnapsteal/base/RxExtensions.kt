package com.kidnapsteal.base

import io.reactivex.Observable
import io.reactivex.Single

fun <T> Observable<T>.composeIoUi(rxScheduler: RxScheduler, view: BaseView): Observable<T> {
    return this.subscribeOn(rxScheduler.io())
            .observeOn(rxScheduler.ui())
            .doOnSubscribe { view.showProgress(true) }
            .doOnTerminate { view.showProgress(false) }
            .doOnError { view.showError(it.message!!) }
}

fun <T> Observable<T>.composeIo(rxScheduler: RxScheduler, view: BaseView): Observable<T> {
    return this.observeOn(rxScheduler.io())
            .doOnError { view.showError(it.message!!) }
}

fun <T> Observable<T>.composeUi(rxScheduler: RxScheduler, view: BaseView): Observable<T> {
    return this.observeOn(rxScheduler.ui())
            .doOnError { view.showError(it.message!!) }
}

fun <T> Single<T>.composeIoUi(rxScheduler: RxScheduler, view: BaseView): Single<T> {
    return this.subscribeOn(rxScheduler.io())
            .observeOn(rxScheduler.ui())
            .doOnSubscribe { view.showProgress(true) }
            .doOnSuccess { view.showProgress(false) }
            .doOnError {
                view.showProgress(false)
                view.showError(it.message!!)
            }
}

fun <T> Single<T>.composeIo(rxScheduler: RxScheduler, view: BaseView): Single<T> {
    return this.observeOn(rxScheduler.io())
            .doOnError { view.showError(it.message!!) }
}

fun <T> Single<T>.composeUi(rxScheduler: RxScheduler, view: BaseView): Single<T> {
    return this.observeOn(rxScheduler.ui())
            .doOnError { view.showError(it.message!!) }
}