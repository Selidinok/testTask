package com.example.testtask.main.domain.mapper

import com.example.testtask.api.domain.entities.Note
import com.example.testtask.main.presentation.NoteState
import javax.inject.Inject

class MainMapper @Inject constructor() {

    fun map(data: List<Note>): List<NoteState> {
        return data.map {
            NoteState(
                id = it.id,
                title = it.title,
                body = it.body,
            )
        }
    }
}