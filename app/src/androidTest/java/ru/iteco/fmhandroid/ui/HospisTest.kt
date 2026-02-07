package ru.iteco.fmhandroid.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.*
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.helpers.AuthHelper
import ru.iteco.fmhandroid.ui.pages.LoginPage
import ru.iteco.fmhandroid.ui.pages.MainPage

@LargeTest
@RunWith(AndroidJUnit4::class)
class AppActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(AppActivity::class.java)

    companion object {
        private const val TEST_LOGIN = "login2"
        private const val TEST_PASSWORD = "password2"
    }

    private val loginPage = LoginPage()
    private val mainPage = MainPage()
    private val authHelper = AuthHelper()

    @Before
    fun setUp() {
        authHelper.logoutIfLoggedIn()
    }

    @After
    fun tearDown() {
        authHelper.logoutIfLoggedIn()
    }

    @Test
    fun entrance() {
        loginPage.checkLoginScreen()
        authHelper.login(TEST_LOGIN, TEST_PASSWORD)
        mainPage.checkMainScreen()
    }

//    @Test НЕ ЗНАЮ!!!!!!!!!!!!!!!
//    fun exit() {
//        // Проверяем экран логина
//        loginPage.checkLoginScreen()
//
//        // Логинимся
//        authHelper.login(TEST_LOGIN, TEST_PASSWORD)
//
//        // Выходим из аккаунта
//        mainPage.logout()
//
//        // Проверяем экран логина после логаута
//        loginPage.checkLoginScreen()
//    }

    @Test
    fun LoginError() {
        loginPage.checkLoginScreen()
        authHelper.login("abc","abc")

        loginPage.checkLoginError()
    }
}





//
//@LargeTest
//@RunWith(AndroidJUnit4::class)
//class AppActivityTest {
//
//    @Rule
//    @JvmField
//    var activityRule = ActivityScenarioRule(AppActivity::class.java)
//
//    companion object {
//        private const val TEST_LOGIN = "login2"
//        private const val TEST_PASSWORD = "password2"
//    }
//
//    @Before
//    fun setUp() {
//        // Проверяем, не залогинены ли мы уже
//        try {
//            // Если видим кнопку выхода - выходим
//            onView(withId(R.id.authorization_image_button))
//                .check(matches(isDisplayed()))
//                .perform(click())
//
//            Thread.sleep(1000)
//
//            onView(withText("Log out"))
//                .perform(click())
//
//            Thread.sleep(2000)
//        } catch (e: Exception) {
//            // Мы еще не залогинены - это нормально
//            println("Пользователь не залогинен, продолжаем")
//        }
//    }
//
//    @After
//    fun tearDown() {
//        // После каждого теста выходим из аккаунта
//        try {
//            onView(withId(R.id.authorization_image_button))
//                .perform(click())
//
//            Thread.sleep(1000)
//
//            onView(withText("Log out"))
//                .perform(click())
//        } catch (e: Exception) {
//            // Уже вышли или не было входа
//        }
//    }
//
//    @Test
//    fun entrance() {
//        Thread.sleep(5000)
//
//        onView(withId(R.id.login_text_input_layout))
//            .check(matches(isDisplayed()))
//
//        onView(withId(R.id.login_edit_text))
//            .perform(replaceText(TEST_LOGIN), closeSoftKeyboard())
//
//        onView(withId(R.id.password_edit_text))
//            .perform(replaceText(TEST_PASSWORD), closeSoftKeyboard())
//
//
//        onView(withId(R.id.enter_button))
//            .perform(click())
//
//        Thread.sleep(1000)
//        onView(withId(R.id.trademark_image_view))
//            .check(matches(isDisplayed()))
//
//    }
//
//    @Test
//    fun exit() {
//        Thread.sleep(5000)
//
//        onView(withId(R.id.login_text_input_layout))
//            .check(matches(isDisplayed()))
//
//        onView(withId(R.id.login_edit_text))
//            .perform(replaceText(TEST_LOGIN), closeSoftKeyboard())
//
//        onView(withId(R.id.password_edit_text))
//            .perform(replaceText(TEST_PASSWORD), closeSoftKeyboard())
//
//
//        onView(withId(R.id.enter_button))
//            .perform(click())
//
//        onView(withId(R.id.authorization_image_button)).perform(click())
//
//        Thread.sleep(1000)
//        onView(withText("Log out")).perform(click())
//
//        Thread.sleep(2000)
//        onView(withId(R.id.enter_button)).check(matches(isDisplayed()))
//    }
//}
//
