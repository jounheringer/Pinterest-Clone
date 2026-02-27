package com.reringuy.pinterwork

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.reringuy.pinterwork.screen.LoginScreenWrapper
import com.reringuy.pinterwork.screen.login.LoginCredentialsWrapper
import com.reringuy.pinterwork.utils.ApplicationRoutes

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = ApplicationRoutes.Login
        ) {
            composable<ApplicationRoutes.Login> {
                LoginScreenWrapper {
                    navController.navigate(ApplicationRoutes.LoginCredentials(it)) {
                        launchSingleTop = true
                    }
                }
            }
            composable<ApplicationRoutes.LoginCredentials> {
                val email = it.toRoute<ApplicationRoutes.LoginCredentials>().email
                LoginCredentialsWrapper(
                    email = email,
                    onNavigateBack = { navController.popBackStack() },
                    onLogin = {
                        navController.navigate(ApplicationRoutes.Home) {
                            popUpTo(ApplicationRoutes.Login::class) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<ApplicationRoutes.Home> {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "AAAAAAAAAAAAAAAAAAAAAAA",
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}