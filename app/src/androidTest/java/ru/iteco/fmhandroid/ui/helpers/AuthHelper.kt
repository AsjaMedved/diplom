package ru.iteco.fmhandroid.ui.helpers

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.pages.LoginPage
import ru.iteco.fmhandroid.ui.pages.MainPage

class AuthHelper {

    private val loginPage = LoginPage()
    private val mainPage = MainPage()

    fun logoutIfLoggedIn() {
        if (isElementDisplayed(R.id.authorization_image_button)) {
            mainPage.logout()
            loginPage.checkLoginScreen()
        }
    }

    fun login(login: String, password: String) {
        loginPage.checkLoginScreen()
        loginPage.login(login, password)
    }

    private fun isElementDisplayed(@IdRes id: Int): Boolean {
        return try {
            onView(withId(id)).check(matches(isDisplayed()))
            true
        } catch (e: Exception) {
            false
        }
    }
}
