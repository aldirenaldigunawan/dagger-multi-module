package com.kidnapsteal.mini_tech_talk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kidnapsteal.bmodule.BActivity
import com.kidnapsteal.bmodule.BActivity.Companion.EXTRA_USER_ID
import com.kidnapsteal.commit.presentation.CommitActivity
import com.kidnapsteal.commit.presentation.CommitActivity.Companion.EXTRA_USER_NAME
import com.kidnapsteal.commit.presentation.CommitActivity.Companion.EXTRA_USER_REPO
import com.kidnapsteal.mini_tech_talk.presentation.a.AActivity
import com.kidnapsteal.mini_tech_talk.presentation.a.AActivity.Companion.EXTRA_ID
import com.kidnapsteal.mini_tech_talk.utils.onClick
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extra = "Extra Data - "

        moduleA.onClick {
            startActivity(Intent(this, AActivity::class.java).apply {
                putExtra(EXTRA_ID, extra + Random().nextLong())
            })
        }
        moduleB.onClick {
            startActivity(Intent(this, BActivity::class.java).apply{
                putExtra(EXTRA_USER_ID, extra + Random().nextLong())
            })
        }

        moduleC.onClick {
            startActivity(Intent(this, CommitActivity::class.java).apply {
                putExtra(EXTRA_USER_NAME, "rails")
                putExtra(EXTRA_USER_REPO, "rails")
            })
        }
    }
}
