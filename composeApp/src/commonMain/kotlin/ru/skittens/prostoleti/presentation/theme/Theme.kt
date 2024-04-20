package ru.skittens.prostoleti.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import prostoleti.composeapp.generated.resources.MPLUSRounded1c
import prostoleti.composeapp.generated.resources.Res

private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable () -> Unit
) {
    val typography = Typography(
        displayLarge = TextStyle(
            fontSize = 34.sp,
            lineHeight = 40.8.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(800),
        ),
        titleLarge = TextStyle(
            fontSize = 28.sp,
            lineHeight = 36.4.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(500),
        ),
        titleMedium = TextStyle(
            fontSize = 18.sp,
            lineHeight = 23.4.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(500),
        ),
        titleSmall = TextStyle(
            fontSize = 17.sp,
            lineHeight = 25.5.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(800),
        ),
        headlineMedium = TextStyle(
            fontSize = 17.sp,
            lineHeight = 22.1.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(500),
        ),
        bodyMedium = TextStyle(
            fontSize = 17.sp,
            lineHeight = 20.4.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(400),
        ),
        bodySmall = TextStyle(
            fontSize = 15.sp,
            lineHeight = 16.5.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(500),
        ),
        labelMedium = TextStyle(
            fontSize = 13.sp,
            lineHeight = 19.5.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(400),
        ),
        labelSmall = TextStyle(
            fontSize = 13.sp,
            lineHeight = 19.5.sp,
            fontFamily = FontFamily(Font(Res.font.MPLUSRounded1c)),
            fontWeight = FontWeight(400),
        )
    )
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState
    ) {
        val isDark by isDarkState
        SystemAppearance(!isDark)
        MaterialTheme(colorScheme = if (isDark) DarkColorScheme else LightColorScheme,
            typography = typography,
            content = { Surface(content = content) })
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)