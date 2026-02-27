package com.reringuy.pinterwork.utils

import kotlinx.serialization.Serializable

@Serializable
sealed class ApplicationRoutes {
    @Serializable
    object Login : ApplicationRoutes()
    @Serializable
    data class LoginCredentials(val email: String) : ApplicationRoutes()
    @Serializable
    object Home : ApplicationRoutes()
}