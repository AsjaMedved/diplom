package ru.iteco.fmhandroid.ui.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.iteco.fmhandroid.R

class LoginPage {

    fun checkLoginScreen() {
        Thread.sleep(3000)
        onView(withId(R.id.login_text_input_layout))
            .check(matches(isDisplayed()))
    }

    fun login(login: String, password: String) {
        onView(withId(R.id.login_edit_text))
            .perform(replaceText(login), closeSoftKeyboard())

        onView(withId(R.id.password_edit_text))
            .perform(replaceText(password), closeSoftKeyboard())

        onView(withId(R.id.enter_button))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun checkLoginError() {
        onView(withText("Something went wrong. Try again later."))
            .check(matches(isDisplayed()))
    }
}
//        Thread.sleep(2000)
//        onView(withId(R.id.enter_button)).check(matches(isDisplayed()))