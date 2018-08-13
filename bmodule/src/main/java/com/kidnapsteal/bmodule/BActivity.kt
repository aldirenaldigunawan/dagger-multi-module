package com.kidnapsteal.bmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_b.*
import javax.inject.Inject

class BActivity : AppCompatActivity(), BContract.View {

    /**
     * TODO Inject Presenter
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val extra = intent.getStringExtra(EXTRA_USER_ID)
        renderSomething(extra)
    }

    override fun renderSomething(something: String) {
        textView.text = something
    }

    companion object {
        const val EXTRA_USER_ID = "BActivity.extra_user_id"
    }
}