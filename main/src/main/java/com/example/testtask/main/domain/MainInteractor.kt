package com.example.testtask.main.domain

import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.main.domain.mapper.MainMapper
import com.example.testtask.main.presentation.NoteState
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val repository: NotesRepository,
    private val mainMapper: MainMapper,
) {

    suspend fun getNoteState(): List<NoteState> {
        return mainMapper.map(repository.getNotes())
    }
}
