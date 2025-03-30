package com.example.testtask.create.domain.mapper

import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import com.example.testtask.create.presentation.CreateData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateMapperTest {

    private val mapper = CreateMapper()

    @Test
    fun map() {
        val data = Note("", "", "")
        val createData = CreateData("")

        val result = mapper.map(data)

        assertEquals(createData, result)
    }

    @Test
    fun mapCreationRequest() {
        val data = CreateData()
        val request = NoteCreationRequest("", "")

        val result = mapper.mapCreationRequest(data)

        assertEquals(request, result)
    }

    @Test
    fun mapNote() {
        val data = CreateData()
        val note = Note("", "", "")

        val result = mapper.mapNote(data)

        assertEquals(note, result)
    }
}