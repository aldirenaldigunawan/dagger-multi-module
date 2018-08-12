package com.kidnapsteal.bmodule

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_b.*
import javax.inject.Inject

class BActivity : DaggerAppCompatActivity(), BContract.View {

    @Inject
    lateinit var presenter: BContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        presenter.attachView(this)
    }

    override fun renderSomething(something: String) {
        textView.text = something
    }

    companion object {
        const val EXTRA_USER_ID = "BActivity.extra_user_id"
    }
}