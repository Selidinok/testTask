package com.example.testtask.navigation

import kotlinx.serialization.Serializable

object Screens {
    @Serializable
    object MainScreen

    @Serializable
    data class CreateScreen(val id: String?)

    @Serializable
    data class NoteScreen(val id: String)
}
