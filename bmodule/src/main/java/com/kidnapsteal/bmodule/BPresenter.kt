package com.kidnapsteal.bmodule

class BPresenter(private val userId: String) : BContract.Presenter {


    private lateinit var view: BContract.View

    override fun attachView(view: BContract.View) {
        this.view = view

        loadData()
    }

    override fun detachView() {

    }

    private fun loadData() {
        view.renderSomething(userId)
    }
}