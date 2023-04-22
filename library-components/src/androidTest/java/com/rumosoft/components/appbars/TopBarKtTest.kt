package com.rumosoft.components.appbars

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import com.rumosoft.components.R
import org.junit.Rule
import org.junit.Test

internal class TopBarKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun titleShouldBeDisplayed() = test {
        composeTestRule.setContent {
            TopBar(apBarText = title)
        }

        composeTestRule.onNodeWithText(title, useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun backShouldNotBeDisplayed() = test {
        composeTestRule.setContent {
            TopBar(apBarText = title)
        }

        composeTestRule.onNodeWithContentDescription(back, useUnmergedTree = true)
            .assertDoesNotExist()
    }

    @Test
    fun backShouldBeDisplayed() = test {
        composeTestRule.setContent {
            TopBar(
                apBarText = title,
                navigationIconType = NavigationIconType.Back(onIconClicked = {})
            )
        }

        composeTestRule.onNodeWithContentDescription(back, useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun menuShouldBeDisplayed() = test {
        composeTestRule.setContent {
            TopBar(
                apBarText = title,
                navigationIconType = NavigationIconType.Menu(onIconClicked = {})
            )
        }

        composeTestRule.onNodeWithContentDescription(menu, useUnmergedTree = true)
            .assertIsDisplayed()
    }

    private fun test(block: TestScope.() -> Unit) {
        TestScope().block()
    }

    private class TestScope {
        val title = "title"
        val context: Context = InstrumentationRegistry.getInstrumentation().context
        val back = context.getString(R.string.back)
        val menu = context.getString(R.string.menu)
    }
}