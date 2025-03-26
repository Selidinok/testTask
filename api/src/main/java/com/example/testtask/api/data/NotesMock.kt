package com.example.testtask.api.data

import com.example.testtask.api.data.entities.NoteListResponse
import com.example.testtask.api.data.entities.NoteResponse

object NotesMock {

    val note = NoteResponse(
        "1",
        "First title",
        "First text",
    )

    val notesResponse = NoteListResponse(
        listOf(
            NoteResponse(
                "1",
                "First title",
                "First text",
            ),
            NoteResponse(
                "1",
                "Second title",
                "Second text",
            ),
            NoteResponse(
                "1",
                "Third title",
                "Third text",
            ),
        )
    )
}