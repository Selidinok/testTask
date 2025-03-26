package com.example.testtask.note.domain.mapper

import com.example.testtask.api.domain.entities.Note
import com.example.testtask.note.presentation.NoteData
import javax.inject.Inject

class NoteMapper @Inject constructor() {

    fun map(data: Note): NoteData =
        NoteData(
            id = data.id,
            title = data.title,
            body = data.body,
        )
}