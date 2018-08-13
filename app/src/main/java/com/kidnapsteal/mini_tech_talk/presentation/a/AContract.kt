package com.kidnapsteal.mini_tech_talk.presentation.a

import com.kidnapsteal.base.BasePresenter
import com.kidnapsteal.base.BaseView

interface AContract {

    interface Presenter : BasePresenter<View> {
        fun loadSomeething()
    }

    interface View : BaseView {
        fun renderSomething(list: List<String>)
    }

}