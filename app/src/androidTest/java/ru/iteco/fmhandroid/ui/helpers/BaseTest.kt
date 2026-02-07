//package ru.iteco.fmhandroid.ui.helpers
//
//import androidx.test.ext.junit.rules.ActivityScenarioRule
//import org.junit.After
//import org.junit.Before
//import org.junit.Rule
//import ru.iteco.fmhandroid.ui.AppActivity
//import ru.iteco.fmhandroid.ui.pages.LoginPage
//import ru.iteco.fmhandroid.ui.pages.MainPage
//
//abstract class BaseTest {
//
//    @get:Rule
//    val activityRule = ActivityScenarioRule(AppActivity::class.java)
//
//    protected val LoginPage = LoginPage()
//    protected val MainPage = MainPage()
//    protected val AuthHelper = AuthHelper()
//
//    companion object {
//        const val TEST_LOGIN = "login2"
//        const val TEST_PASSWORD = "password2"
//    }
//
//    @Before
//    fun setUp() {
//        AuthHelper.ensureCleanState()
//    }
//
//    @After
//    fun tearDown() {
//        AuthHelper.cleanup()
//    }
//}