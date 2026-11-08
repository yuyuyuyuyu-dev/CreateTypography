package dev.yuyuyuyuyu.createtypography.example

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import createtypographyexample.shared.generated.resources.Res
import createtypographyexample.shared.generated.resources.Yomogi_Regular
import dev.yuyuyuyuyu.createtypography.createTypographyFrom
import org.jetbrains.compose.resources.Font

@Composable
@Preview
fun App() {
    MaterialTheme(
        typography = createTypographyFrom(fontFamily = FontFamily(Font(Res.font.Yomogi_Regular))),
    ) {
        Scaffold { innerPadding ->
            TextColumn(modifier = Modifier.padding(innerPadding))
        }
    }
}
