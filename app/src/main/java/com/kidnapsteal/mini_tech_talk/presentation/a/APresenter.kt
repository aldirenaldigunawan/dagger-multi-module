package com.kidnapsteal.mini_tech_talk.presentation.a

import javax.inject.Inject

class APresenter @Inject constructor(): AContract.Presenter{

    private lateinit var view: AContract.View

    override fun loadSomeething() {
        view.renderSomething(listOf("1","2","3"))
    }

    override fun attachView(view: AContract.View) {
        this.view = view
    }

    override fun detachView() {
        throw NotImplementedError()
    }

}