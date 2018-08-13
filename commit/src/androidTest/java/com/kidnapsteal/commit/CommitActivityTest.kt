package com.kidnapsteal.commit

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.kidnapsteal.base.InjectedActivityTestRule
import com.kidnapsteal.base.dispatchingActivity
import com.kidnapsteal.commit.data.entity.Author
import com.kidnapsteal.commit.data.entity.Commit
import com.kidnapsteal.commit.presentation.CommitActivity
import com.kidnapsteal.commit.presentation.CommitContract
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CommitActivityTest {

    @get:Rule
    val rule = InjectedActivityTestRule(CommitActivity::class.java,
            dispatchingActivity<CommitActivity> {
                it.presenter = presenter
            })
    private val presenter: CommitContract.Presenter = mock()
    private lateinit var view: CommitContract.View

    @Before
    fun setup() {
        rule.launchActivity(Intent().apply {
            putExtra(CommitActivity.EXTRA_USER_NAME, "")
            putExtra(CommitActivity.EXTRA_USER_REPO, "")
        })
        view = rule.activity
    }

    @Test
    fun test_render_commits() {
        val commits = getCommits()

        rule.activity.runOnUiThread {
            view.renderCommits(commits)
        }

        onView(withId(R.id.recyclerView))
                .check(matches(hasDescendant(withText("Author-1"))))
    }

    private fun getCommits(): List<Commit> {
        return (1..10).map {
            Commit(author = Author(name = "Author-$it"),
                    message = "Commit Messages -- $it")
        }
    }
}