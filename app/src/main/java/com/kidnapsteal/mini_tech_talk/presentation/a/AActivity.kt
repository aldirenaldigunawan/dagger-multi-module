package com.kidnapsteal.mini_tech_talk.presentation.a

import android.os.Bundle
import android.util.Log
import com.kidnapsteal.mini_tech_talk.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_a.*
import javax.inject.Inject
import javax.inject.Named

class AActivity : DaggerAppCompatActivity(), AContract.View {


    companion object {
        const val EXTRA_ID = "AActivity_extra_id"
        const val TAG = "AActivity"
    }

    @Inject
    @field:Named("NAME_EXTRA_ID")
    lateinit var extraId: String

    @Inject
    lateinit var presenter: AContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        presenter.attachView(this)
        presenter.loadSomeething()

        textViewExtra.text = extraId
    }

    override fun renderSomething(list: List<String>) {
        Log.d(TAG, "renderSomething : listSize --- ${list.size}")
    }

    override fun showProgress(show: Boolean) {
        Log.e(TAG, "showProgress --- $show")
    }

    override fun showError(message: String) {
        Log.e(TAG, "showError --- $message")
    }
}