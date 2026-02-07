package ru.iteco.fmhandroid.ui.pages

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.iteco.fmhandroid.R

class MainPage {
    fun checkMainScreen() {
        Thread.sleep(1000)
        onView(withId(R.id.trademark_image_view))
            .check(matches(isDisplayed()))
    }

    fun logout() {
        // Ждем пока кнопка Authorization станет видимой
        waitForView(R.id.authorization_image_button)

        onView(withId(R.id.authorization_image_button))
            .perform(click())

        onView(withText("Log out"))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    private fun waitForView(@IdRes id: Int, timeout: Long = 5000) {
        val startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - startTime < timeout) {
            try {
                onView(withId(id)).check(matches(isDisplayed()))
                return
            } catch (e: Exception) {
                Thread.sleep(100)
            }
        }
        throw AssertionError("View with id=$id not displayed after $timeout ms")
    }
}