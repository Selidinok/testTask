package com.example.testtask.api.data.mapper

import com.example.testtask.api.data.entities.NoteListResponse
import com.example.testtask.api.data.entities.NoteResponse
import com.example.testtask.api.domain.entities.Note

fun NoteListResponse.toNotes(): List<Note> = data.map { it.toNote() }

fun NoteResponse.toNote(): Note = Note(
    id = id,
    title = title,
    body = body,
)
