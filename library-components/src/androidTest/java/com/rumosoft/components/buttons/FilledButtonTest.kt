package com.rumosoft.components.buttons

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

internal class FilledButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun theTextShouldBeDisplayed() {
        val text = "Button text"

        composeTestRule.setContent {
            FilledButton.Primary.Create(text = text)
        }

        composeTestRule.onNodeWithText(text.uppercase()).assertIsDisplayed()
    }

    @Test
    fun theOnClickShouldBeInvokedWhenPressed() {
        val text = "Button text"
        val onClick: () -> Unit = mockk()
        justRun { onClick() }
        composeTestRule.setContent {
            FilledButton.Primary.Create(
                text = text,
                onClick = onClick
            )
        }

        composeTestRule.onNodeWithText(text.uppercase()).performClick()

        verify { onClick() }
    }
}
