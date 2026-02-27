package com.reringuy.pinterwork

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
fun App(onNavHostReady: () -> Unit = {}) {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = ApplicationRoutes.Login
        ) {
            composable<ApplicationRoutes.Login> {
                LoginScreenWrapper {
                    navController.navigate(ApplicationRoutes.LoginCredentials(it)){
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
                        navController.popBackStack(
                            route = ApplicationRoutes.Home,
                            inclusive = false
                        )
                    }
                )
            }
            composable<ApplicationRoutes.Home> {

            }
        }
    }
}