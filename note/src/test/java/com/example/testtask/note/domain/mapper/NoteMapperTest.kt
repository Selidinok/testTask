package com.example.testtask.note.domain.mapper

import com.example.testtask.api.domain.entities.Note
import com.example.testtask.note.presentation.NoteData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NoteMapperTest {

    private val mapper = NoteMapper()

    @Test
    fun `map Note to NoteData`() {
        val note = Note("1", "title", "body")
        val noteData = NoteData("1", "title", "body")

        val result = mapper.map(note)

        assertEquals(noteData, result)
    }
}