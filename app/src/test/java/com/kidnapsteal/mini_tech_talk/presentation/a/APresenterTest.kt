package com.kidnapsteal.mini_tech_talk.presentation.a

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class APresenterTest {

    @Test
    fun test_presenter_attached() {
        val view: AContract.View = mock()

        val presenter = APresenter()

        presenter.attachView(view)
        presenter.loadSomeething()

        verify(view).renderSomething(any())
    }
}