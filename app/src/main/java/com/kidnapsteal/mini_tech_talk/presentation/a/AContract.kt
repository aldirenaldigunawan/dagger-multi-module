package com.kidnapsteal.mini_tech_talk.presentation.a

import com.kidnapsteal.mini_tech_talk.BaseView

interface AContract{

    interface Presenter: BaseView<View>{
        fun loadSomeething()
    }

    interface View{
        fun renderSomething(list: List<String>)
    }

}