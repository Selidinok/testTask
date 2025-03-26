package com.example.testtask.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ErrorContent(
    error: String,
    onRefresh: () -> Unit,
) {
    Column(
        modifier = Modifier.Companion
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = error)
        IconButton(
            onClick = onRefresh,
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Create",
            )
        }
    }
}
