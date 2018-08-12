package com.kidnapsteal.bmodule

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockitokotlin2.mock
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BActivityTest {

    val presenter: BContract.Presenter = mock()

    @get:Rule
    val rule = BActivityTestRule {
        (it as BActivity)
        it.presenter = presenter
    }

    @Before
    fun setup() {
        rule.launchActivity(null)
    }

    @Test
    fun screen_display_data() {
        val expectedStringDisplayed = ""

        onView(withId(R.id.textView)).check(matches(withText(expectedStringDisplayed)))
    }
}