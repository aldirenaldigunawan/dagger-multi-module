package com.kidnapsteal.mini_tech_talk.presentation.a

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.kidnapsteal.mini_tech_talk.AActivityTestRule
import com.kidnapsteal.mini_tech_talk.InjectedActivityTestRule
import com.kidnapsteal.mini_tech_talk.R
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AActivityTest {

    @get:Rule
    val ruleActivity = AActivityTestRule {
        (it as AActivity)

        it.presenter = presenterMock
        it.extraId = "JANCOK"
    }

    var presenterMock: AContract.Presenter = mock()

    @Before
    fun setup() {
        ruleActivity.launchActivity(null)
    }

    @Test
    fun extra_string_should_rendered_on_activity_launch() {
        onView(withId(R.id.textViewExtra))
                .check(matches(withText("JANCOK")))
                .check(matches(isDisplayed()))

        verify(presenterMock).loadSomeething()

    }

}