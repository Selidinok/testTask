package com.example.testtask.create.domain

import com.example.testtask.api.domain.NotesRepository
import com.example.testtask.create.domain.mapper.CreateMapper
import com.example.testtask.create.presentation.CreateData
import javax.inject.Inject

class CreateInteractor @Inject constructor(
    private val repository: NotesRepository,
    private val mapper: CreateMapper,
) {

    suspend fun getNote(id: String): CreateData {
        return mapper.map(repository.getNote(id))
    }

    suspend fun addNote(data: CreateData) {
        if (data.id == null) {
            repository.createNote(mapper.mapCreationRequest(data))
        } else {
            repository.updateNote(mapper.mapNote(data))
        }
    }
}