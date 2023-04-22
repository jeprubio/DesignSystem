package com.rumosoft.components.appbars

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import com.rumosoft.components.R
import org.junit.Assert.assertTrue

internal class NavigationIconKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun backShouldBeDisplayedOnNavigateIconBack() = test {
        composeTestRule.setContent {
            NavigationIcon(navigationIconType = NavigationIconType.Back(onIconClicked = {}))
        }

        composeTestRule.onNodeWithContentDescription(back, useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun menuShouldBeDisplayedOnNavigateIconMenu() = test {
        composeTestRule.setContent {
            NavigationIcon(navigationIconType = NavigationIconType.Menu(onIconClicked = {}))
        }

        composeTestRule.onNodeWithContentDescription(menu, useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun theOnClickShouldBeInvokedWhenPressed() = test {
        var clicked = false
        val onClick = { clicked = true }
        composeTestRule.setContent {
            NavigationIcon(navigationIconType = NavigationIconType.Back(onIconClicked = onClick))
        }

        composeTestRule.onNodeWithContentDescription(back, useUnmergedTree = true).performClick()

        assertTrue(clicked)
    }

    private fun test(block: TestScope.() -> Unit) {
        TestScope().block()
    }

    private class TestScope {
        val context: Context = InstrumentationRegistry.getInstrumentation().context
        val back = context.getString(R.string.back)
        val menu = context.getString(R.string.menu)
    }
}