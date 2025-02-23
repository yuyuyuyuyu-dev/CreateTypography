package dev.yuyuyuyuyu.createtypography.example.multiplatform

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import createtypography.composeapp.generated.resources.Res
import createtypography.composeapp.generated.resources.Yomogi_Regular
import dev.yuyuyuyuyu.createtypography.createTypographyFrom
import org.jetbrains.compose.resources.Font

@Composable
fun App() {
    MaterialTheme(
        typography = createTypographyFrom(fontFamily = FontFamily(Font(Res.font.Yomogi_Regular))),
    ) {
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding),
            ) {
                Text(
                    text = "Hello, ${getPlatform().name}!",
                )
            }
        }
    }
}
