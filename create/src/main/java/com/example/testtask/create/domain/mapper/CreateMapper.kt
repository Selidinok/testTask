package com.example.testtask.create.domain.mapper

import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import com.example.testtask.create.presentation.CreateData
import javax.inject.Inject

class CreateMapper @Inject constructor() {

    fun map(data: Note): CreateData {
        return CreateData(
            id = data.id,
            title = data.title,
            body = data.body,
        )
    }

    fun mapCreationRequest(data: CreateData): NoteCreationRequest {
        return NoteCreationRequest(
            title = data.title,
            body = data.body,
        )
    }

    fun mapNote(data: CreateData): Note {
        return Note(
            id = data.id.orEmpty(),
            title = data.title,
            body = data.body,
        )
    }
}