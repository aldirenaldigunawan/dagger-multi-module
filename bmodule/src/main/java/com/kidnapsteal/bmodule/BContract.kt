package com.kidnapsteal.bmodule

interface BContract{
    interface View{
        fun renderSomething(something: String)
    }

    interface Presenter{
        fun attachView(view: View)
        fun detachView()
    }
}