package vk.test.task

import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText


class MainActivityTest {

    @get:Rule
    var activityActivityTestRule: ActivityTestRule<MainActivity?>? = ActivityTestRule(
            MainActivity::class.java
    )

    @Test
    fun test_with_correct_input() {
        onView(withId(R.id.inputField)).perform(typeText("Alina"))
        onView(withId(R.id.submitBTN)).perform(click())
        onView(withId(R.id.textLabel)).check(matches(withText("Alina")))
    }

    @Test
    fun test_with_too_large_input() {
        onView(withId(R.id.inputField)).perform(typeText("i have wrote too much chars. for sure. more than 25"))
        onView(withId(R.id.submitBTN)).perform(click())
        onView(withId(R.id.textLabel)).check(matches(withText("i have wrote too much cha")))
    }

    @Test
    fun test_with_empty_input() {
        onView(withId(R.id.submitBTN)).perform(click())
        onView(withId(R.id.textLabel)).check(matches(withText("")))
    }

    @Test
    fun test_with_enter() {
        onView(withId(R.id.inputField)).perform(typeText("341@&#& 2#&1@371\n" +
                "2"))
        onView(withId(R.id.submitBTN)).perform(click())
        onView(withId(R.id.textLabel)).check(matches(withText("341@&#& 2#&1@371\n" +
                "2")))
    }

    //TextInputEditText при вводе знака табуляции закрывает форму редактирования
    @Test
    fun test_with_tabulation() {
        onView(withId(R.id.inputField)).perform(typeText("341@&#&\t 2#&1@371\n" +
                "2"))
        onView(withId(R.id.submitBTN)).perform(click())
        onView(withId(R.id.textLabel)).check(matches(withText("341@&#&")))
    }

    @Test
    fun test_with_canceled_input() {
        onView(withId(R.id.inputField)).perform(typeText("341@&#&2#&1@371\n" +
                "2"))
        onView(withId(R.id.inputField)).perform(clearText())
        onView(withId(R.id.submitBTN)).perform(click())
        onView(withId(R.id.textLabel)).check(matches(withText("")))
    }
}