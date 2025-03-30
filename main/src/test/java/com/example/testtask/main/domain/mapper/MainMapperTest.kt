package com.example.testtask.main.domain.mapper

import com.example.testtask.api.domain.entities.Note
import com.example.testtask.main.presentation.NoteState
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainMapperTest {

    private val mapper = MainMapper()

    @Test
    fun `map notes to state`() {
        val notes = listOf(Note("1", "1", "1"))
        val state = listOf(NoteState("1", "1", "1"))

        val result = mapper.map(notes)

        assertEquals(state, result)
    }
}