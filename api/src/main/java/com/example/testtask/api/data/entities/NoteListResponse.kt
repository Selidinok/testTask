package com.example.testtask.api.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class NoteListResponse(
    val data: List<NoteResponse>,
)