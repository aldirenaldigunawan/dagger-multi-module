package com.kidnapsteal.mini_tech_talk.presentation.b

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.kidnapsteal.bmodule.BActivity
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BActivityTest {

    val mockStringA = "MockStringA"
    val mockStringB = "MockStringB"
    val mockStringC = "MockStringC"

    @get:Rule
    val rule = ActivityTestRule<BActivity>(BActivity::class.java)
//    val rule = BActivityTestRule {
//        (it as BActivity)
//        it.stringA = mockStringA
//        it.stringB = mockStringB
//        it.stringC = mockStringC
//    }

    @Before
    fun setup() {
//        rule.launchActivity(null)
    }

    @Test
    fun screen_display_data() {
        val expectedStringDisplayed = "String A||String B||String C"

        onView(withText(expectedStringDisplayed)).check(matches(isDisplayed()))
    }
}