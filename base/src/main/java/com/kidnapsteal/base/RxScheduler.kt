package com.kidnapsteal.base

import io.reactivex.Scheduler


interface RxScheduler {
    fun io(): Scheduler
    fun ui(): Scheduler
    fun compute(): Scheduler
    fun newThread(): Scheduler
}

class RxSchedulerImpl(
        private val io: Scheduler,
        private val ui: Scheduler,
        private val compute: Scheduler,
        private val newThread: Scheduler
) : RxScheduler {
    override fun io(): Scheduler = io

    override fun ui(): Scheduler = ui

    override fun compute(): Scheduler = compute

    override fun newThread(): Scheduler = newThread

}