package com.example.testtask.note.domain

import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.note.domain.mapper.NoteMapper
import com.example.testtask.note.presentation.NoteData
import javax.inject.Inject

class NoteInteractor @Inject constructor(
    private val repository: NotesRepository,
    private val mapper: NoteMapper,
) {

    suspend fun getNote(id: String): NoteData {
        return mapper.map(repository.getNote(id))
    }
}