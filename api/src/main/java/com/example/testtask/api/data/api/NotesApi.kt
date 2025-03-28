package com.example.testtask.api.data.api

import com.example.testtask.api.data.entities.NoteListResponse
import com.example.testtask.api.data.entities.NoteResponse
import com.example.testtask.api.domain.entities.Note
import com.example.testtask.api.domain.entities.NoteCreationRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface NotesApi {
    @GET("api/notes")
    suspend fun getNotes(): NoteListResponse

    @GET("api/note/{id}")
    suspend fun getNote(@Path("id") id: String): NoteResponse

    @PUT("api/note")
    suspend fun updateNote(@Body request: Note): NoteResponse

    @POST("api/note")
    suspend fun createNote(@Body request: NoteCreationRequest): NoteResponse
}

@Module
@InstallIn(SingletonComponent::class)
object NotesApiModule {
    @Provides
    fun provideNotesApi(retrofit: Retrofit): NotesApi =
        retrofit.create(NotesApi::class.java)
}
