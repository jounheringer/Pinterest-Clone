package com.reringuy.pinterwork

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Pinterwork",
    ) {
        App()
    }
}