package com.kidnapsteal.mini_tech_talk

interface BaseView<T> {

    fun attachView(view: T)
    fun detachView()
}