package dev.yuyuyuyuyu.createtypography.example.multiplatform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TextColumn(modifier: Modifier = Modifier) = Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    Text(
        text = "displayLarge",
        style = MaterialTheme.typography.displayLarge,
    )
    Text(
        text = "displayMedium",
        style = MaterialTheme.typography.displayMedium,
    )
    Text(
        text = "displaySmall",
        style = MaterialTheme.typography.displaySmall,
    )
    Text(
        text = "headlineLarge",
        style = MaterialTheme.typography.headlineLarge,
    )
    Text(
        text = "headlineMedium",
        style = MaterialTheme.typography.headlineMedium,
    )
    Text(
        text = "headlineSmall",
        style = MaterialTheme.typography.headlineSmall,
    )
    Text(
        text = "titleLarge",
        style = MaterialTheme.typography.titleLarge,
    )
    Text(
        text = "titleMedium",
        style = MaterialTheme.typography.titleMedium,
    )
    Text(
        text = "titleSmall",
        style = MaterialTheme.typography.titleSmall,
    )
    Text(
        text = "bodyLarge",
        style = MaterialTheme.typography.bodyLarge,
    )
    Text(
        text = "bodyMedium",
        style = MaterialTheme.typography.bodyMedium,
    )
    Text(
        text = "bodySmall",
        style = MaterialTheme.typography.bodySmall,
    )
    Text(
        text = "labelLarge",
        style = MaterialTheme.typography.labelLarge,
    )
    Text(
        text = "labelMedium",
        style = MaterialTheme.typography.labelMedium,
    )
    Text(
        text = "labelSmall",
        style = MaterialTheme.typography.labelSmall,
    )
}
