package com.example.testtask.api.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class NoteCreationRequest(
    val title: String,
    val body: String,
)