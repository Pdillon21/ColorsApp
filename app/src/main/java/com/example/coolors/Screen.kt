package com.example.coolors

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screen("home", "Home", Icons.Outlined.Home)
    object Profile : Screen("profile", "Profile", Icons.Outlined.Person)

    object Items {
        val list = listOf(Home, Profile)
    }
}
