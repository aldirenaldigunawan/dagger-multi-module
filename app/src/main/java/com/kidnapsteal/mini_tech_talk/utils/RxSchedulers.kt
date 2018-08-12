package com.kidnapsteal.mini_tech_talk.utils

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface RxSchedulers {
    fun io(): Schedulers
    fun ui(): Schedulers
    fun new(): Schedulers
    fun compute(): Schedulers
}

class RxSchedulersImpl @Inject constructor(
        private val io: Schedulers,
        private val ui: Schedulers,
        private val new: Schedulers,
        private val compute: Schedulers
) : RxSchedulers {

    override fun io(): Schedulers = io

    override fun ui(): Schedulers = ui

    override fun new(): Schedulers = new

    override fun compute(): Schedulers = compute

}