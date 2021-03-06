package com.kidnapsteal.base

interface BasePresenter<T> {
    fun attachView(view: T)
    fun detachView()
}