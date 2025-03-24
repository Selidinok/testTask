package com.example.testtask.api.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class NoteResponse(
    val id: String,
    val title: String,
    val body: String,
)