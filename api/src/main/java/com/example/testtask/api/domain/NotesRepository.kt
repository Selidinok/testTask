package com.example.testtask.api.domain

import com.example.testtask.api.domain.entities.Note

interface NotesRepository {
    suspend fun getNotes(): List<Note>
}