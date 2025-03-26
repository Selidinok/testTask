package com.example.testtask.create.presentation

data class CreateState(
    val isLoading: Boolean = true,
    val data: CreateData = CreateData(),
    val error: String? = null,
)

data class CreateData(
    val id: String? = null,
    val title: String = "",
    val body: String = "",
)
