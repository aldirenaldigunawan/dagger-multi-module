package com.kidnapsteal.bmodule

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class BActivityTest {

    @get:Rule
    val rule = ActivityTestRule(BActivity::class.java, false, false)

    private val expectedStringDisplayed = Random().nextInt(Int.MAX_VALUE).toString()

    @Before
    fun setup() {
        rule.launchActivity(Intent().putExtra(BActivity.EXTRA_USER_ID, expectedStringDisplayed))
    }

    @Test
    fun screen_display_data() {
        onView(allOf(withId(R.id.textView), withText(expectedStringDisplayed))).check(matches(isDisplayed()))
    }
}