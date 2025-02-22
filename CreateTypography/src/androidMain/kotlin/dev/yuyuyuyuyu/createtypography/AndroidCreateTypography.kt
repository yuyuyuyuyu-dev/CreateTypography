package dev.yuyuyuyuyu.createtypography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont

fun createTypographyFrom(fontName: String): Typography = createTypographyFrom(
    fontFamily = FontFamily(
        Font(
            googleFont = GoogleFont(name = fontName),
            fontProvider = GoogleFont.Provider(
                providerAuthority = "com.google.android.gms.fonts",
                providerPackage = "com.google.android.gms",
                certificates = R.array.com_google_android_gms_fonts_certs,
            ),
        ),
    ),
)
