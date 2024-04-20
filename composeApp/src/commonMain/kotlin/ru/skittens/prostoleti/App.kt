package ru.skittens.prostoleti

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import ru.skittens.prostoleti.presentation.navigation.EnrolleeMainNavigation
import ru.skittens.prostoleti.presentation.navigation.StudentMainNavigation
import ru.skittens.prostoleti.presentation.routes.GroupRoutes
import ru.skittens.prostoleti.presentation.routes.ScreenRoutes
import ru.skittens.prostoleti.presentation.screens.start.AuthorizationScreen
import ru.skittens.prostoleti.presentation.screens.start.RegistrationScreen
import ru.skittens.prostoleti.presentation.screens.start.SplashScreen
import ru.skittens.prostoleti.presentation.theme.AppTheme

typealias NavigationFun = () -> Unit

@Composable
internal fun App() = AppTheme {
    PreComposeApp {
        val navigator = rememberNavigator()
        NavHost(navigator, GroupRoutes.Start.name, Modifier.fillMaxSize()) {
            group(GroupRoutes.Start.name, ScreenRoutes.Start.Splash.name) {
                scene(ScreenRoutes.Start.Splash.name) {
                    SplashScreen(
                        { navigator.navigate(ScreenRoutes.Start.Authorization.name) },
                        { navigator.navigate(ScreenRoutes.Student.MainStudent.name) },
                        { navigator.navigate(ScreenRoutes.Enrollee.MainEnrollee.name) }
                    )
                }
                scene(ScreenRoutes.Start.Authorization.name) {
                    AuthorizationScreen(
                        { navigator.navigate(ScreenRoutes.Start.Registration.name) },
                        { navigator.navigate(ScreenRoutes.Student.MainStudent.name) },
                        { navigator.navigate(ScreenRoutes.Enrollee.MainEnrollee.name) }
                    )
                }
                scene(ScreenRoutes.Start.Registration.name) {
                    RegistrationScreen(
                        { navigator.navigate(ScreenRoutes.Start.Authorization.name) },
                        { navigator.navigate(ScreenRoutes.Student.MainStudent.name) },
                        { navigator.navigate(ScreenRoutes.Enrollee.MainEnrollee.name) }
                    )
                }
            }

            scene(ScreenRoutes.Student.MainStudent.name) {
                StudentMainNavigation(navigator)
            }

            scene(ScreenRoutes.Enrollee.MainEnrollee.name) {
                EnrolleeMainNavigation(navigator)
            }
        }
    }
}