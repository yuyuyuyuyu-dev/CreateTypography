package dev.yuyuyuyuyu.createtypography.spec

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toPixelMap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.v2.runComposeUiTest
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import dev.yuyuyuyuyu.createtypography.createTypographyFrom
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class CreateTypographyFromFontFamilyTest {
    @Test
    fun `should create Typography that renders every text style in the given font`() =
        runComposeUiTest {
            // Arrange
            val fontFamily =
                FontFamily(
                    Font(identity = "Poppins-Regular", data = readResource("/font/Poppins-Regular.ttf"), weight = FontWeight.Normal),
                    Font(identity = "Poppins-Medium", data = readResource("/font/Poppins-Medium.ttf"), weight = FontWeight.Medium),
                    Font(identity = "Poppins-Bold", data = readResource("/font/Poppins-Bold.ttf"), weight = FontWeight.Bold),
                )
            var textStyle by mutableStateOf(namedTextStyles.first())
            setContent {
                MaterialTheme(typography = createTypographyFrom(fontFamily = fontFamily)) {
                    Column {
                        Text(
                            text = SAMPLE_TEXT,
                            modifier = Modifier.testTag(ACTUAL).clipToBounds(),
                            style = textStyle.of(MaterialTheme.typography),
                        )
                        Text(
                            text = SAMPLE_TEXT,
                            modifier = Modifier.testTag(EXPECTED).clipToBounds(),
                            fontFamily = fontFamily,
                            style = textStyle.of(Typography()),
                        )
                        Text(
                            text = SAMPLE_TEXT,
                            modifier = Modifier.testTag(DEFAULT).clipToBounds(),
                            style = textStyle.of(Typography()),
                        )
                    }
                }
            }

            // Act
            val failures =
                namedTextStyles.mapNotNull { namedTextStyle ->
                    textStyle = namedTextStyle
                    waitForIdle()
                    val actual = onNodeWithTag(ACTUAL).captureToImage()
                    val expected = onNodeWithTag(EXPECTED).captureToImage()
                    val default = onNodeWithTag(DEFAULT).captureToImage()
                    when {
                        expected.hasSamePixelsAs(default) -> "${namedTextStyle.name}: $TEST_FONT_NOT_DISTINCT"
                        !actual.hasSamePixelsAs(expected) -> "${namedTextStyle.name}: $NOT_IN_GIVEN_FONT"
                        else -> null
                    }
                }

            // Assert
            assertEquals(emptyList(), failures)
        }
}

private const val SAMPLE_TEXT = "Typography"
private const val TEST_FONT_NOT_DISTINCT = "the test font renders the same as the default font"
private const val NOT_IN_GIVEN_FONT = "differs from the Material 3 default style rendered in the given font"
private const val ACTUAL = "actual"
private const val EXPECTED = "expected"
private const val DEFAULT = "default"

private class NamedTextStyle(
    val name: String,
    val of: (Typography) -> TextStyle,
)

private val namedTextStyles =
    listOf(
        NamedTextStyle("displayLarge") { it.displayLarge },
        NamedTextStyle("displayMedium") { it.displayMedium },
        NamedTextStyle("displaySmall") { it.displaySmall },
        NamedTextStyle("headlineLarge") { it.headlineLarge },
        NamedTextStyle("headlineMedium") { it.headlineMedium },
        NamedTextStyle("headlineSmall") { it.headlineSmall },
        NamedTextStyle("titleLarge") { it.titleLarge },
        NamedTextStyle("titleMedium") { it.titleMedium },
        NamedTextStyle("titleSmall") { it.titleSmall },
        NamedTextStyle("bodyLarge") { it.bodyLarge },
        NamedTextStyle("bodyMedium") { it.bodyMedium },
        NamedTextStyle("bodySmall") { it.bodySmall },
        NamedTextStyle("labelLarge") { it.labelLarge },
        NamedTextStyle("labelMedium") { it.labelMedium },
        NamedTextStyle("labelSmall") { it.labelSmall },
        NamedTextStyle("displayLargeEmphasized") { it.displayLargeEmphasized },
        NamedTextStyle("displayMediumEmphasized") { it.displayMediumEmphasized },
        NamedTextStyle("displaySmallEmphasized") { it.displaySmallEmphasized },
        NamedTextStyle("headlineLargeEmphasized") { it.headlineLargeEmphasized },
        NamedTextStyle("headlineMediumEmphasized") { it.headlineMediumEmphasized },
        NamedTextStyle("headlineSmallEmphasized") { it.headlineSmallEmphasized },
        NamedTextStyle("titleLargeEmphasized") { it.titleLargeEmphasized },
        NamedTextStyle("titleMediumEmphasized") { it.titleMediumEmphasized },
        NamedTextStyle("titleSmallEmphasized") { it.titleSmallEmphasized },
        NamedTextStyle("bodyLargeEmphasized") { it.bodyLargeEmphasized },
        NamedTextStyle("bodyMediumEmphasized") { it.bodyMediumEmphasized },
        NamedTextStyle("bodySmallEmphasized") { it.bodySmallEmphasized },
        NamedTextStyle("labelLargeEmphasized") { it.labelLargeEmphasized },
        NamedTextStyle("labelMediumEmphasized") { it.labelMediumEmphasized },
        NamedTextStyle("labelSmallEmphasized") { it.labelSmallEmphasized },
    )

private fun readResource(path: String): ByteArray =
    checkNotNull(NamedTextStyle::class.java.getResourceAsStream(path)).use { it.readBytes() }

private fun ImageBitmap.hasSamePixelsAs(other: ImageBitmap): Boolean {
    val pixels = toPixelMap()
    val otherPixels = other.toPixelMap()
    return pixels.width == otherPixels.width &&
        pixels.height == otherPixels.height &&
        pixels.buffer.contentEquals(otherPixels.buffer)
}
